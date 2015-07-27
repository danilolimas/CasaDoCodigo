package br.com.caelum.casadocodigo.listener;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.concurrent.Callable;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.TipoDeCompra;
import br.com.caelum.casadocodigo.activity.MainActivity;
import br.com.caelum.casadocodigo.auxiliador.Auxiliador;
import br.com.caelum.casadocodigo.modelo.Livro;

/**
 * Created by matheus on 24/07/15.
 */
public class ListenerMenuCompra implements View.OnClickListener {
    private MainActivity activity;
    private Livro livro;

    public ListenerMenuCompra(MainActivity activity, Livro livro) {
        this.activity = activity;
        this.livro = livro;
    }

    @Override
    public void onClick(View v) {
        final View alertView = View.inflate(activity, R.layout.opcao_compra, null);


        RadioButton virtual = (RadioButton) alertView.findViewById(R.id.valor_virtual);
        virtual.setText("Virtual : R$ " + livro.getValorVirtual());

        RadioButton fisico = (RadioButton) alertView.findViewById(R.id.valor_fisico);
        fisico.setText("Fisico : R$ " + livro.getValorFisico());

        RadioButton juntos = (RadioButton) alertView.findViewById(R.id.valor_juntos);
        juntos.setText("Juntos : R$ " + livro.getValorDoisJuntos());
        juntos.toggle();


        new AlertDialog.Builder(activity).setView(alertView).setTitle(livro.getNomeLivro()).show();


        Button comprar = (Button) alertView.findViewById(R.id.botao_comprar_livro_alert);

        comprar.setOnClickListener(new ListenerComprarPeloMain(this, livro, activity, new Callable<TipoDeCompra>(){

            @Override
            public TipoDeCompra call() throws Exception {
                return getTipoDeCompra(alertView);
            }
        }));

    }

    public TipoDeCompra getTipoDeCompra(View view){

        TipoDeCompra tipoDeCompra = null;

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radio_group);

        Auxiliador auxiliador = new Auxiliador();

        tipoDeCompra =  auxiliador.auxilia(radioGroup);

        return tipoDeCompra;
    };




}