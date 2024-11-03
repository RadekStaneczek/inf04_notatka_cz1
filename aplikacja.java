import java.util.ArrayList;
import java.util.Scanner;

class Notatka
{
    private static int note_counter = 0;
    private int id;

    protected String tytul,tresc;
    
    Notatka(String tytul_notatki,String tresc_notatki)
    {
        tytul = tytul_notatki;
        tresc = tresc_notatki;

        note_counter++;
        id = note_counter;
    }
    public void show_note()
    {
        System.out.print("----------------------\nIdentyfikator:" + id + "\n\n" + tytul + "\n\n" + tresc + "\n\n----------------------\n\n");
    }
    public void showAll()
    {
        System.out.println(id + ";" + tytul + ";" + tresc + ";" + note_counter);
    }
    public void show_id()
    {
        System.out.println("|" +id + "|");
    }
}
public class aplikacja
{
    public static void main(String args[]) 
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Notatka> notes = new ArrayList<Notatka>();
        String opcja;
        do
        {
            System.out.print("Wybierz opcje: \na)Stworz notatke\nb)Pokaz notatke\nc)Wyjdz z aplikacji\n");
            opcja = input.nextLine();
            if(opcja.equals("a"))
            {
                System.out.println("Podaj tytul notatki:");
                String tytul = input.nextLine();

                System.out.println("Podaj tresc notatki:");
                String tresc = input.nextLine();

                notes.add(new Notatka(tytul, tresc));
            }
            else if(opcja.equals("b") && !notes.isEmpty())
            {
                System.out.println("┌─┐");
                for(int i=0;i< notes.size();i++)
                {
                    notes.get(i).show_id();
                }
                System.out.println("└─┘");
                System.out.println("Podaj identyfikator:");

                int id = input.nextInt();

                if(id > 0)
                {
                    notes.get(id-1).show_note();
                }
            }
            else if(notes.isEmpty() && opcja.equals("b"))
            {
                System.out.println("Nie ma notatek");
            }
        }
        while(!opcja.equals("c"));
        input.close();   
    }
}