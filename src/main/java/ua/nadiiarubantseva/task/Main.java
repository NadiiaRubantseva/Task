package ua.nadiiarubantseva.task;

import static ua.nadiiarubantseva.task.Task.findFirstUniqueCharacter;

public class Main {

    public static void main(String[] args) {
        String text = """
                The Tao gave birth to machine language.  Machine language gave birth
                to the assembler.
                The assembler gave birth to the compiler.  Now there are ten thousand
                languages.
                Each language has its purpose, however humble.  Each language
                expresses the Yin and Yang of software.  Each language has its place within
                the Tao.
                But do not program in COBOL if you can avoid it.
                        -- Geoffrey James, "The Tao of Programming\"""";

        char firstUniqueSymbol = findFirstUniqueCharacter(text).orElseThrow(RuntimeException::new);
        System.out.println("Перший унікальний символ: " + firstUniqueSymbol);
    }

}
