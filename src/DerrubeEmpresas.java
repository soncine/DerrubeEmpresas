import java.util.ArrayList;
import java.io.*;
public class DerrubeEmpresas {
    //declara e inicializa as variaveis que vou precisar
    private GameHelper helper = new GameHelper();
    private ArrayList<empresa> listaEmpresas = new ArrayList<empresa>();
    private int numChutes = 0;

    public static void main(String[] args){
        DerrubeEmpresas jogo = new DerrubeEmpresas();
        jogo.configJogo();
        jogo.comecaJogo();
    }

    //cria tres objetos empresa, os dá um nome e insere na ArrayList
    private void configJogo() {
        empresa um = new empresa();
        empresa dois = new empresa();
        empresa tres = new empresa();
        um.criaNome("Pets.com");
        dois.criaNome("eToys.com");
        tres.criaNome("Go2.com");
        listaEmpresas.add(um);
        listaEmpresas.add(dois);
        listaEmpresas.add(tres);

        //exibe instruções resumidas pro usuário
        System.out.println("Seu objetivo é eliminar três empresas");
        System.out.println("Pets.com, eToys.com e Go2.com");
        System.out.println("Tente eliminar todas com o menor numero de palpites");
        for (empresa configEmpresa : listaEmpresas){
            ArrayList<String> novaLoc = helper.placeDotCom(3);
            configEmpresa.criaLocCels(novaLoc);
        }
    }

    private void comecaJogo(){
        while(!listaEmpresas.isEmpty()){
            String userGuess = helper.getUserInput("Insira um chute: ");
            checkUserGuess(userGuess);
        }
        acabaJogo();
    }

    private void checkUserGuess(String userGuess){
        numChutes++;
        String resultado = "errado";
        for (empresa empresaTeste : listaEmpresas){
            resultado = empresaTeste.checkMe(userGuess);
            if (resultado.equals("acertou")){
                break;
            }
            if (resultado.equals("eliminar")){
                listaEmpresas.remove(empresaTeste);
                break;
            }
        }
        System.out.println(resultado);
    }

    private void acabaJogo(){
        System.out.println("Todas as empresas foram eliminadas! Agora seu conjunto está vazio.");
        if (numChutes <= 18){
            System.out.printf("Você só usou %d chutes\n", numChutes);
        } else {
            System.out.printf("Lento demais. Você precisou de %d chutes\n", numChutes);
        }
    }

    public class empresa{
        private ArrayList<String> locCels;
        private String nome;

        public void criaLocCels(ArrayList<String> loc){
            locCels = loc;
        }

        public void criaNome(String n){
            nome = n;
        }

        public String checkMe(String input) {
            String resultado = "errado";

            int index = locCels.indexOf(input);
            if (index >= 0) {
                locCels.remove(index);

                if (locCels.isEmpty()) {
                    resultado = "eliminar";
                    System.out.printf("Boa! você derrubou a %s \n", nome);
                } else {
                    resultado = "acertou";
                }
            }
            return resultado;
        }
    }

    public class GameHelper{
        private static final String alfabeto = "abcdefg";
        private int gradeLarg = 7;
        private int gradeTam = 49;
        private int [] grade = new int[gradeTam];
        private int empNum = 0;


        public String getUserInput(String prompt){
            String inputLine = null;
            System.out.print(prompt + " ");
            try {
                BufferedReader is = new BufferedReader( new InputStreamReader(System.in) );
                inputLine = is.readLine();
                if(inputLine.length()== 0 ) return null;
            }
            catch(IOException e) {
                System.out.println("IOException : " + e);
            }
            return inputLine.toLowerCase();
        }

        public ArrayList<String> placeDotCom(int comSize){
            ArrayList<String> alphaCells = new ArrayList<String>();
            String[] alphacoords = new String[comSize];
            String temp = null;
            int[] coords = new int[comSize];
            int attempts = 0;
            boolean success = false;
            int location;

            empNum++;
            int incr = 1;
            if( (empNum % 2) == 1){
                incr = gradeLarg;
            }

            while(!success & attempts++ < 200) {
                location = (int)(Math.random() * gradeTam);
// System.out.println("try" + local);
                int x = 0;
                success = true;
                while(success && x < comSize) {
                    if(grade[location] == 0) {
                        coords[x++] = location;
                        location += incr;
                        if(location >= gradeTam){
                            success = false;
                        }
                        if(x > 0 && (location % gradeLarg == 0) ) {
                            success = false;
                        }
                    }
                    else{
                        System.out.println("used" + location);
                        success = false;
                    }
                }
            }

            int x = 0;
            int row = 0;
            int column = 0;
            System.out.println("\n");
            while(x < comSize) {
                grade[coords[x]] = 1;
                row = (int)(coords[x] / gradeLarg);
                column = coords[x] % gradeLarg;
                temp = String.valueOf(alfabeto.charAt(column));

                alphaCells.add(temp.concat(Integer.toString(row)));
                x++;
            }
            return alphaCells;
        }
    }
}
