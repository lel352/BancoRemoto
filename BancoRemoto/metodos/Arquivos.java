/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3.metodos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Leandro
 */
public class Arquivos {

    public void escreverIni(String mensagem, String logFile, boolean rescrever) throws IOException {
        FileWriter escritorArquivos = new FileWriter(logFile, rescrever);
        BufferedWriter bufferedWriter = new BufferedWriter(escritorArquivos);
        bufferedWriter.newLine();
        bufferedWriter.write(mensagem);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void rescreverumaLinhaIni(String mensagem, String logFile, boolean rescrever, String linhaAterior) throws IOException {
        FileWriter escritorArquivos = new FileWriter(logFile, rescrever);
        BufferedWriter bufferedWriter = new BufferedWriter(escritorArquivos);
        BufferedReader bufferedreader = new BufferedReader(new FileReader(logFile));


        String linha;
        while ((linha =  bufferedreader.readLine()) != null) {
            if (linha.contains(linhaAterior)) {
                linha = linha.replace(linhaAterior, mensagem);
                bufferedWriter.write(linha);
                break;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedreader.close();
    }

    public String lendoIni(String logFile, String buscar) throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(logFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
       // bufferedReader.readLine();
        String linha = null;
        String linhaAnterior = null;
        if (buscar == null) {
            while (bufferedReader.ready()) {
                linhaAnterior = linha;
                linha = bufferedReader.readLine().trim();

            }
        } else {
            do {
                linha = bufferedReader.readLine().trim();
                if (linha.indexOf(buscar) > -1) {
                    linhaAnterior = linha;
               //     break;
                }
            }while (bufferedReader.ready());
        }
        bufferedReader.close();

        return linhaAnterior;
    }

    public void regravarLinha(String mensagem, String linhaAnterior) {// pega uma informaçao

        try {
            String diretorio = System.getProperty("user.dir");
            diretorio = diretorio + "\\caminho";

            String arquivo = diretorio + "\\caminho.txt";

            //rescreverumaLinhaIni(mensagem, arquivo, true, linhaAnterior);
            escreverIni(mensagem, arquivo, true);

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado!!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não pode ser lido!!");
        }
    }

    public String pegarinformacao(String pegar) {// pega uma informaçao

        try {
            String diretorio = System.getProperty("user.dir");
            diretorio = diretorio + "\\caminho";
            pegar = pegar + "=";

            String linha = lendoIni(diretorio + "\\caminho.txt", pegar);
            int inicio = -1, fim = -1;
            inicio = linha.indexOf(pegar);
            fim = linha.indexOf(";");
            if ((inicio == -1) || (fim == -1)) {
                return null;
            }

            inicio = inicio + pegar.length();
            String resu = linha.substring((inicio), (fim));
            return resu;


        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não encontrado!!");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Arquivo não pode ser lido!!");
        }


        return null;
    }
}
