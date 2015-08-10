package br.com.caelum.casadocodigo.leitorDeLivros;

/**
 * Created by matheus on 23/07/15.
 */
public class LeitorDeLivrosFactory {

    public static LeitorDeLivros getLeitorDeLivros(int i) {


        //LeitorDeLivros leitorDeLivros = new LeitorDeLivrosArquivo(new OnlyOpenRawResource(activity.getResources()));

        // LeitorDeLivros leitorDeLivros = new LeitorDeLivrosHardCode();

        LeitorDeLivros leitorDeLivros = new LeitorDeLivrosServidor(i);

        return leitorDeLivros;
    }
}
