package service;

public enum Operation {
    //if an arithmetic operation has only one argument, it should contain the name "_1arg"
    plus(" + "), minus(" - "), divide(" / "), multiply(" * "), square_root_1arg("square root");
    
    private Operation(final String text) {
        this.text = text;
    }
   
    private final String text;

    @Override
    public String toString() {
        return text;
    }
}
