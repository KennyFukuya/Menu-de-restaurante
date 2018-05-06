package restaurante;

import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class MenuOpcao {
    
    public static void PainelADM(){
        System.out.println("--------------------------------------------");
        System.out.println("|     1- Adicionar comidas ao cardapio     |");
        System.out.println("|     2- Adicionar bebidas ao cardapio     |");
        System.out.println("|     3- Mostrar o cardapio                |");
        System.out.println("|     4- Alterar item do cardapio          |");
        System.out.println("|     5- Remover item do cardapio          |");
        System.out.println("|     6- Voltar pro menu principal         |");
        System.out.println("--------------------------------------------");
    }
    
    public static void PainelUsuario(){
        System.out.println("--------------------------------------------");
        System.out.println("|     1- Visualizar o cardapio             |");
        System.out.println("|     2- Descricao do prato                |");
        System.out.println("|     3- Realizar pedido                   |");
        System.out.println("|     4- Voltar pro menu principal         |");
        System.out.println("--------------------------------------------");
    }
    
    private int i=0,inputADM,inputUSER;
    private static int indice=1;

    Bebidas drink[] = new Bebidas[6];  //define uma qnt maxima de bebidas e comidas
    Comidas food[] = new Comidas[8];

    Scanner optionUSER = new Scanner(System.in);
    Scanner optionADM = new Scanner(System.in);
    Scanner modify = new Scanner(System.in);
    Scanner pass = new Scanner(System.in);
    Scanner leNome = new Scanner(System.in);
    Scanner lePreco = new Scanner(System.in);
    Scanner leTam = new Scanner(System.in);
    Scanner leEstoque = new Scanner(System.in);
    Scanner leMarca = new Scanner(System.in);
    Scanner descreve = new Scanner(System.in);
    Scanner userOrder = new Scanner(System.in);
        

    public void inicializaProdutos(){  //Instancia os produtos com um indicador de indice (CODE) e stock=0 para comparacoes
        for(i=0;i<8;i++){
            food[i] = new Comidas(indice,0);
            indice++;
        }

        for(i=0;i<6;i++){
            drink[i] = new Bebidas(indice,0);
            indice++;
        }
    }
    
    public void mainMenu(){  
        boolean checkloop=true; //usado pra manter o loop
        do{
            System.out.println("--------------------------------------------");
            System.out.println("| Bem Vindo ao Restaurante Universitario!! |");
            System.out.println("|          1- Usuario                      |");
            System.out.println("|          2- Administrador                |");
            System.out.println("|          3- Fechar o programa            |");
            System.out.println("--------------------------------------------");

            Scanner fullLoop = new Scanner(System.in);

            int option = fullLoop.nextInt();

            switch(option){
                case 1:
                    checkloop=false; //EVITA LOOPS QUANDO EXECUTA O MAINMENU DENOVO
                    this.menuUser();
                    break;
                case 2:
                    checkloop=false; //EVITA LOOPS QUANDO EXECUTA O MAINMENU DENOVO
                    this.menuADM();
                    break;
                case 3: 
                    checkloop=false; //EVITA LOOPS QUANDO EXECUTA O MAINMENU DENOVO
                    System.out.println("============ Programa desenvolvido por Arthur Paiva Camilo e Kenny Kenjiro Fukuya ============");
                    System.exit(0);  //FECHA O PROGRAMA
                    break;
                default:
                    System.out.println("\nERRO: Opcao invalida!!!\n");
            }
        }while(checkloop==true);
    }
    
    public void menuADM(){
        boolean checkloopADM=true;
        
        System.out.print("Digite a Senha (Peru): ");
        String password = pass.nextLine();
        if("Peru".equals(password)){
            do{
                PainelADM();
                inputADM=optionADM.nextInt();
                switch(inputADM){
                    case 1: 
                        int contErrorFood=0;
                        for(int index=0;index<8;index++){
                            if("".equals(food[index].getName())){
                                System.out.print("Digite o nome da comida: ");
                                String foodName = leNome.nextLine();

                                System.out.print("Digite quantas pessoas serve: ");
                                int foodSize = leTam.nextInt();

                                System.out.print("Digite o preco da comida: ");
                                float foodPrice = lePreco.nextFloat();

                                System.out.print("Digite a quantidade de estoque (unidades): ");
                                int foodStock = leEstoque.nextInt();

                                food[index].addItem(foodName,foodSize,foodPrice,foodStock);
                                
                                System.out.println("\nComida adicionada ao cardapio com sucesso!!!");
                                contErrorFood--;
                                break;
                            }else{
                                contErrorFood++;
                            }
                        }if(contErrorFood==8){
                            System.out.println("\nERRO: Limite atingido!!!\n");
                        }
                        break;

                    case 2:
                        int contErrorDrink=0;
                        for(int index=0;index<6;index++){
                            if("".equals(drink[index].getName())){
                                System.out.print("Digite o nome da bebida: ");
                                String drinkName = leNome.nextLine();

                                System.out.print("Digite a marca da bebida: ");
                                String drinkBrand = leMarca.nextLine();

                                System.out.print("Digite o preco da bebida: ");
                                float drinkPrice = lePreco.nextFloat();

                                System.out.print("Digite a quantidade de estoque (unidades): ");
                                int drinkStock = leEstoque.nextInt();

                                drink[index].addItem(drinkName,drinkPrice,drinkBrand,drinkStock);
                                
                                System.out.println("\nBebida adicionada ao cardapio com sucesso!!!");
                                contErrorDrink--;
                                break;
                            }else{
                                contErrorDrink++;
                            }
                        }if(contErrorDrink==6){
                            System.out.println("\nERRO: Limite atingido!!!\n");
                        }
                        break;

                    case 3:
                        System.out.print("  ** COMIDAS **  \n");
                        for(i=0;i<8;i++){
                            System.out.print(food[i].showItems());
                        }

                        System.out.print("\n  ** BEBIDAS **  \n");
                        for(i=0;i<6;i++){
                            System.out.print(drink[i].showItems());
                        }
                        break;

                    case 4:
                        System.out.print("Digite o codigo do produto a ser alterado: ");
                        int modifyCode = modify.nextInt();
                        if(modifyCode<9){
                            for(i=0;i<8;i++){
                                if(food[i].getCode()==modifyCode){
                                    System.out.print("Nome: ");
                                    String foodName = leNome.nextLine();
                                    
                                    System.out.print("Digite quantas pessoas serve: ");
                                    int foodSize = leTam.nextInt();

                                    System.out.print("Preco: ");
                                    float foodPrice = lePreco.nextFloat();

                                    System.out.print("Estoque: ");
                                    int foodStock = leEstoque.nextInt();

                                    food[i].changeItem(foodName,foodSize,foodPrice,foodStock);
                                    
                                    System.out.println("\nProduto alterado com sucesso!!!");
                                }
                            }
                        }else if(modifyCode<15){
                            for(i=0;i<6;i++){
                                if(drink[i].getCode()==modifyCode){
                                    System.out.print("Nome: ");
                                    String drinkName = leNome.nextLine();
                                    
                                    System.out.print("Marca: ");
                                    String drinkBrand = leMarca.nextLine();

                                    System.out.print("Preco: ");
                                    float drinkPrice = lePreco.nextFloat();

                                    System.out.print("Estoque: ");
                                    int drinkStock = leEstoque.nextInt();

                                    drink[i].changeItem(drinkName,drinkPrice,drinkBrand,drinkStock);
                                    
                                    System.out.println("\nProduto alterado com sucesso!!!");
                                }
                            }
                        }else{
                            System.out.println("\nERRO: Impossivel alterar!!!\n");
                        }
                        break;

                    case 5:
                        System.out.print("Digite o codigo do produto a ser removido: ");
                        int removeCode = modify.nextInt();
                        if(removeCode<9){
                            for(i=0;i<8;i++){
                                if(food[i].getCode()==removeCode){
                                    food[i].removeItem();
                                }
                            }
                        }else if(removeCode<15){
                            for(i=0;i<6;i++){
                                if(drink[i].getCode()==removeCode){
                                    drink[i].removeItem();
                                }
                            }
                        }else{
                            System.out.println("\nERRO: Opcao invalida!!!\n");
                        }
                        break;
                    case 6:
                        this.mainMenu();
                        checkloopADM=false;
                        break;
                    default:System.out.println("\nERRO: Opcao invalida!!!\n");
                }
            }while(checkloopADM==true);
        }else{
            System.out.println("\nERRO: SENHA INVALIDA!!!\n");
        }
    }

    public void menuUser(){
        boolean checkloopUser=true;
        do{
            PainelUsuario();
            inputUSER=optionUSER.nextInt();
            switch(inputUSER){
                case 1:
                    System.out.print("  ** COMIDAS **  \n");
                    for(i=0;i<8;i++){
                        System.out.print(food[i].showItemsUser());
                    }

                    System.out.print("\n  ** BEBIDAS **  \n");
                    for(i=0;i<6;i++){
                        System.out.print(drink[i].showItemsUser());
                    }                    
                    break;

                case 2:
                    System.out.print("Digite o codigo: ");
                    int codDescreve = descreve.nextInt();
                    if(codDescreve<9){
                            for(i=0;i<8;i++){
                                if(food[i].getCode()==codDescreve){
                                    System.out.print("\n"+food[i].description());
                                }
                            }
                        }else if(codDescreve<15){
                            for(i=0;i<6;i++){
                                if(drink[i].getCode()==codDescreve){
                                    System.out.print("\n"+drink[i].description());
                                }
                            }
                        }else{
                            System.out.println("\nERRO: Produto inexistente!!!\n");
                        }
                    break;

                case 3:
                    System.out.print("Digite o codigo do pedido: ");
                    int codOrder = userOrder.nextInt();
                    if(codOrder<9){
                            for(i=0;i<8;i++){
                                if(food[i].getCode()==codOrder){
                                    if(food[i].getStock()!=Disponibilidade.FALSE.getValor()){
                                        food[i].order();
                                        System.out.println("\n"+food[i].describeOrder());
                                    }else{
                                        if(!"".equals(food[i].getName()))
                                            System.out.println("\nERRO: Produto esgotado!!!\n");
                                        else
                                            System.out.println("\nERRO: Produto inexistente!!!\n");
                                    }
                                }
                            }
                        }else if(codOrder<15){
                            for(i=0;i<6;i++){
                                if(drink[i].getCode()==codOrder){
                                    if(drink[i].getStock()!=Disponibilidade.FALSE.getValor()){
                                        drink[i].order();
                                        System.out.println("\n"+drink[i].describeOrder());
                                    }else{
                                        if(!"".equals(drink[i].getName()))
                                            System.out.println("\nERRO: Produto esgotado!!!\n");
                                        else
                                            System.out.println("\nERRO: Produto inexistente!!!\n");
                                    }
                                }
                            }
                        }else{
                            System.out.println("\nERRO: Produto inexistente!!!\n");
                        }
                    break;
                case 4:
                    this.mainMenu();
                    checkloopUser=false;
                    break;
                default:
                    System.out.println("\nERRO: Opcao invalida!!!\n");
            }
        }while(checkloopUser==true);   
    }
    
}
