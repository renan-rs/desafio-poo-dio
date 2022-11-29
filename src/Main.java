
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

public class Main {

    private static List<Bootcamp> bootcamps = new ArrayList<>();
    private static Set<Dev> devs = new LinkedHashSet<>();
    
    public static void main(String[] args) {
        fillBootcamps();
        Scanner scanner = new Scanner(System.in);
        while(true){
            menuPrincipal(scanner);
        }
    }

    public static void menuPrincipal(Scanner scanner){
        System.out.println();
        System.out.println("-----\tMenu - Principal\t-----");
        System.out.println("1) Listar Bootcamps");
        System.out.println("2) Matricular Dev em um Bootcamp");
        //System.out.println("3) Listas devs");
        System.out.println("0) Encerrar");
        System.out.print("Informe uma opção: ");
        String choice = scanner.nextLine();
        switch(choice){
            case "1":
                System.out.println("-----\tBootcamps disponíveis\t-----");
                listarBootcamps();
                break;
            case "2":
                System.out.println("-----\tMatricular Dev\t-----");
                Dev dev = criarDev(scanner);
                int devMatriculado = matricularDev(scanner, dev);
                if(devMatriculado > -1){
                    System.out.println("-------------------");
                    System.out.println("| DEV MATRICULADO |");
                    System.out.println("-------------------");
                    System.out.println();
                } else {
                    System.out.println("--------------------------");
                    System.out.println("| ERRO AO MATRICULAR DEV |");
                    System.out.println("--------------------------");
                    System.out.println();
                }
                break;
            case "0":
            System.out.println("--------------");
            System.out.println("| ENCERRANDO |");
            System.out.println("--------------");
            System.out.println();
                System.exit(0);
                break;
            default:
                System.out.println("------------------");
                System.out.println("| OPÇÃO INVÁLIDA |");
                System.out.println("------------------");
                System.out.println();
        }
    }

    public static Dev criarDev(Scanner scanner){
        System.out.print("Informe o nome do Dev: ");
        String nomeDev = scanner.nextLine();
        Dev dev = new Dev();
        dev.setNome(nomeDev);
        System.out.println();
        return dev;

    }
    public static int matricularDev(Scanner scanner, Dev dev){
        System.out.println("Bootcamps disponíveis: ");
        int c = 0;
        for(Bootcamp bootcamp : bootcamps){
            System.out.println("\tID: " + (c+1) + " - " + bootcamp.getNome());
            c++;
        }
        int choice = -1;
        while(choice == -1){
            System.out.print("Informe o ID do Bootcamp que deseja matricular o dev,\nou 0 para cancelar: ");
            String bootcampIdEscolhido = scanner.nextLine();
            if(bootcampIdEscolhido.equals("0")) break;

            try{
                if(Integer.valueOf(bootcampIdEscolhido)-1 < 0 || 
                Integer.valueOf(bootcampIdEscolhido)-1 > bootcamps.size()){
                    System.out.println("ID de Bootcamp inválido!");
                    continue;
                }
                choice = Integer.parseInt(bootcampIdEscolhido)-1;
                dev.inscreverBootcamp(bootcamps.get(choice));
            } catch(NumberFormatException e){
                System.out.println("ID de Bootcamp inválido!");
                continue;
            }
        }
        return choice;
    }

    public static void listarBootcamps(){
        int c = 0;
        for(Bootcamp bootcamp : bootcamps){
            System.out.println("ID: " + (c+1) + " - " + bootcamp);
            c++;
        }
    }

    public static void fillBootcamps(){
        Curso curso1 = new Curso("Curso Java", "Descrição curso java", 8);
        Curso curso2 = new Curso("Curso JS", "Descrição curso js", 4);
        Mentoria mentoria = new Mentoria("Mentoria de Java", "Descrição mentoria java");

        Bootcamp bootcamp = new Bootcamp("Bootcamp Java Developer", "Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);
        bootcamps.add(bootcamp);

        Curso cursoPy1 = new Curso("Curso Python", "Descrição curso python", 7);
        Curso cursoPy2 = new Curso("Curso Python Web", "Descrição curso python web", 5);
        Mentoria mentoriaPy = new Mentoria("Mentoria de Python", "Descrição mentoria python");

        Bootcamp bootcamp2 = new Bootcamp("Bootcamp Python Developer", "Descrição Bootcamp Python Developer");
        bootcamp2.getConteudos().add(cursoPy1);
        bootcamp2.getConteudos().add(cursoPy2);
        bootcamp2.getConteudos().add(mentoriaPy);
        bootcamps.add(bootcamp2);
    }

}
