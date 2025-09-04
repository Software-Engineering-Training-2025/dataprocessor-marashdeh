package org.example.dataprocessor.output;

public class console implements outputType{
    @Override
    public void output(double list) {System.out.println("result ="+list);}
}