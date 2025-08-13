package Sample;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author RafaelRocha, ViníciusAmaral, TallesCardoso
 * Classe contendo o método calculaNucleotideos que retorna um array com a sequencia e erros.
 * 
 */
public class Utils {
    
    public int[] calculaNucleotideos(String dna) throws Exception{
        int a = 0, c = 0, g = 0, t = 0, erros = 0;
        if("".equals(dna)){
            throw new Exception("String vazia!");
        }
        for(int i = 0; i  < dna.length(); i++){
            char id = Character.toLowerCase(dna.charAt(i));
            switch (id) {
                case 'a':
                    a++;
                    break;
                case 'c':
                    c++;
                    break;
                case 'g':
                    g++;
                    break;
                case 't':
                    t++;
                    break;
                default:
                    erros++;
                    break;
            }
        }
        int[] sequencia = {a,c,g,t,erros};
        
        int validos = a+c+g+t;
        
        if(validos/10 < erros){
            return null;
        }
        return sequencia;
    }
}
