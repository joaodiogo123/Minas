package com.joaopires.minas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    protected int[] id_botoes;
    protected Button b;
    protected TextView t;
    protected EditText w;
    protected int i;
    protected Button[] bArray;
    protected Random ran = new Random();
    protected int[] minasPosicoes;
    protected int atulaMina = 0;
    protected int[] bCarregados;
    protected int existe = 0;
    protected int atualCarregados = 0;

    public void carregarBotao(View view){
        int a = view.getId();

        //Verificar se o botão já foi carregado anterioremente
        //É importante fazer esta verificação para que não possamos alterar o conteudo de um botão (se tem mina ou não) depois de carregarmos nele a primeira vez.
        //E para que o vetor de minas não estoure se carregarmos vezes demais.
        //Ou seja, só executamos o código se o botão ainda não tiver sido carregado, depois disso não fazemos nada (apenas mostramos o seu ID) quando o mesmo é carregado novamente.
        for(i = 0; i < bCarregados.length; i++){

            if (a == bCarregados[i]){
                existe = 1;
                break;
            }
        }

        if (existe == 0){ //Se não tiver sido carregado vamos por o seu id no vetor de botões carregados e executar o código de quando se carrega num botão
            bCarregados[atualCarregados] = a;
            atualCarregados++;

            Button carregado = ((Button) view);
            carregado.setText(Integer.toString(minasPosicoes[atulaMina]));
            if(minasPosicoes[atulaMina] == 1) {
                w.setText("Mina!");
            }else
                w.setText("");

            atulaMina++;

        }
        existe = 0;
        t.setText(Integer.toString(a));

        if(atulaMina == 56){
            w.setText("Terminou o jogo.");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView)findViewById(R.id.t);
        w = (EditText)findViewById(R.id.w);

        id_botoes = new int[] {R.id.b01, R.id.b02, R.id.b03, R.id.b04, R.id.b05, R.id.b06, R.id.b07,
                R.id.b11, R.id.b12, R.id.b13, R.id.b14, R.id.b15, R.id.b16, R.id.b17,
                R.id.b21, R.id.b22, R.id.b23, R.id.b24, R.id.b25, R.id.b26, R.id.b27,
                R.id.b31, R.id.b32, R.id.b33, R.id.b34, R.id.b35, R.id.b36, R.id.b37,
                R.id.b41, R.id.b42, R.id.b43, R.id.b44, R.id.b45, R.id.b46, R.id.b47,
                R.id.b51, R.id.b52, R.id.b53, R.id.b54, R.id.b55, R.id.b56, R.id.b57,
                R.id.b61, R.id.b62, R.id.b63, R.id.b64, R.id.b65, R.id.b66, R.id.b67,
                R.id.b71, R.id.b72, R.id.b73, R.id.b74, R.id.b75, R.id.b76, R.id.b77};

        bArray = new Button[56];
        minasPosicoes = new int[56];
        bCarregados = new int[56];

        for(i=0; i < id_botoes.length; i++) {

            bArray[i] = (Button) findViewById(id_botoes[i]);

            bArray[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    carregarBotao(v);
                }
            });
        }

        for(i=0; i < minasPosicoes.length; i++){

            minasPosicoes[i] = ran.nextInt(2); //Número random entre 0 e 1
        }


    }
}