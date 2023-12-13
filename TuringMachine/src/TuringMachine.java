class TuringMachine {
    private final String string;
    private int index;
    private Status status;

    TuringMachine(String string) {
        this.string = string;
        index = 0;
        status = Status.START;
        checkString();
        System.out.println(status);
    }

    private char nextChar() {
        char nextChar = 0;
        try {
            nextChar = Character.toLowerCase(string.charAt(index));
            index++;
        } catch (IndexOutOfBoundsException e) {
            status = Status.NOT_OK;
        }
        return nextChar;
    }

    private void checkString() {
        char currentChar;
        while (true) {
            System.out.println(status);
            currentChar = nextChar();

            switch (status) {
                case START:
                    if (currentChar == 'a') {
                        status = Status.A_FOUND;
                    }
                    break;
                case A_FOUND:
                    if (currentChar == 'a') {
                        break;
                    } else if (currentChar == 'b') {
                        status = Status.B_FOUND;
                    } else if (currentChar == 'd') {
                        status = Status.D_FOUND;
                    } else {
                        status = Status.START;
                    }
                    break;
                case B_FOUND:
                    if (currentChar == 'c') {
                        status = Status.C_FOUND;
                    } else {
                        status = Status.START;
                    }
                    break;
                case C_FOUND:
                    if (currentChar == 'b') {
                        status = Status.B_FOUND;
                    } else if (currentChar == 'd') {
                        status = Status.D_FOUND;
                    } else {
                        status = Status.START;
                    }
                    break;
                case D_FOUND:
                    if (currentChar == 'd') {
                        status = Status.OK;
                    } else {
                        status = Status.START;
                    }
                    break;
            }

            if (status == Status.OK || status == Status.NOT_OK) {
                return;
            }
        }
    }
}
