package binarytree;

import table.Table;

import java.util.Arrays;

public class TreeBuilder {
    private final String message;
    private final LetterKnot[] letterKnots;
    private final BinaryTree binaryTree;
    private final Table table;

    public TreeBuilder(String message) {
        this.message = message;
        char[] distinctLetters = distinctLetters();
        letterKnots = buildLetterKnots(distinctLetters);
        binaryTree = connectKnotsToTree();
        binaryTree.setBranchValues();
        table = binaryTree.buildEncodingTable();
    }

    private BinaryTree connectKnotsToTree() {
        Knot[] currentKnots = letterKnots;
        while (currentKnots.length > 2) {
            currentKnots = connectLowestKnotPairToNewKnot(currentKnots);
        }
        return initializeBinaryTree(currentKnots);
    }

    private Knot[] connectLowestKnotPairToNewKnot(Knot[] currentKnots) {
        Knot[] lowestKnots = collectLowestKnotPair(currentKnots);
        currentKnots = removeKnotsFromKnots(lowestKnots, currentKnots);
        Knot newKnot = buildKnot(lowestKnots);
        return addNewKnot(currentKnots, newKnot);
    }

    private BinaryTree initializeBinaryTree(Knot[] currentKnots) {
        SourceKnot sourceKnot = buildSourceKnot(currentKnots);
        return new BinaryTree(sourceKnot);
    }

    private Knot[] addNewKnot(Knot[] oldKnots, Knot newKnot) {
        Knot[] newKnots = Arrays.copyOf(oldKnots, oldKnots.length + 1);
        newKnots[oldKnots.length] = newKnot;
        return newKnots;
    }

    private Knot buildKnot(Knot[] lowestKnots) {
        int usageCount = lowestKnots[0].getUsageCount() + lowestKnots[1].getUsageCount();
        return new Knot(usageCount, lowestKnots[0], lowestKnots[1]);
    }

    private SourceKnot buildSourceKnot(Knot[] lowestKnots) {
        int usageCount = lowestKnots[0].getUsageCount() + lowestKnots[1].getUsageCount();
        return new SourceKnot(usageCount, lowestKnots[0], lowestKnots[1]);
    }

    private Knot[] removeKnotsFromKnots(Knot[] knotsToRemove, Knot[] knots) {
        for (Knot knotToRemove : knotsToRemove) {
            knots = removeKnotFromKnots(knotToRemove, knots);
        }
        return knots;
    }

    private Knot[] removeKnotFromKnots(Knot knotToRemove, Knot[] knots) {
        Knot[] newKnots = new Knot[knots.length - 1];
        int knotIndex = 0;

        for (Knot knot : knots) {
            if (knot.equals(knotToRemove)) {
                continue;
            }
            newKnots[knotIndex] = knot;
            knotIndex++;
        }
        return newKnots;
    }

    private Knot[] collectLowestKnotPair(Knot[] knots) {
        Knot[] lowestKnotPair = new Knot[2];
        int lowestKnotIndex = 0;

        while (lowestKnotIndex < 2) {
            Knot lowestKnot = searchKnotWithUsageCount(lowestKnotUsage(knots), knots);
            if (lowestKnot != null) {
                lowestKnotPair[lowestKnotIndex] = lowestKnot;
                lowestKnotIndex++;
                knots = removeKnotFromKnots(lowestKnot, knots);
            }
        }
        return lowestKnotPair;
    }

    private Knot searchKnotWithUsageCount(int usage, Knot[] knots) {
        for (Knot knot : knots) {
            if (knot.getUsageCount() == usage) {
                return knot;
            }
        }
        return null;
    }

    private int lowestKnotUsage(Knot[] knots) {
        int lowestUsage = Integer.MAX_VALUE;
        for (Knot knot : knots) {
            if (knot.getUsageCount() < lowestUsage) {
                lowestUsage = knot.getUsageCount();
            }
        }
        return lowestUsage;
    }

    private LetterKnot[] buildLetterKnots(char[] letters) {
        LetterKnot[] letterKnots = new LetterKnot[letters.length];
        for (int letter = 0; letter < letters.length; letter++) {
            int usageCount = usageCount(letters[letter]);
            letterKnots[letter] = new LetterKnot(usageCount, letters[letter]);
        }
        return letterKnots;
    }

    private int usageCount(char letter) {
        int usageCount = 0;
        for (int charIndex = 0; charIndex < message.length(); charIndex++) {
            if (message.charAt(charIndex) == letter) {
                usageCount++;
            }
        }
        return usageCount;
    }

    private char[] distinctLetters() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int charIndex = 0; charIndex < message.length(); charIndex++) {
            if (firstOccurrenceInMessage(charIndex)) {
                stringBuilder.append(message.charAt(charIndex));
            }
        }
        return stringBuilder.toString().toCharArray();
    }

    private boolean firstOccurrenceInMessage(int charIndex) {
        char letter = message.charAt(charIndex);
        return message.indexOf(letter) == charIndex;
    }

    public Table getTable() {
        return table;
    }
}
