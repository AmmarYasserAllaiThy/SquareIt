package app;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import static app.utils.toInt;

public class Main {

    public static void main(String[] args) throws IOException {
        final SquareIt squareIt = new SquareIt();

        if (!(args.length == 3 || args.length == 5)) throw new IllegalArgumentException(
                "Illegal Arguments...\n image padding color ratio[Width Height][optional]");

        squareIt.setImageFile(new File(args[0]))
                .setPadding(toInt(args[1]))
                .setColor(args[2]);

        if (args.length == 5) squareIt.setRatio(new Dimension(toInt(args[3]), toInt(args[4])));

        boolean written = squareIt.start();

        if (written) System.out.println("Done.");
        else System.err.println("Can't write image to disk.");
    }
}