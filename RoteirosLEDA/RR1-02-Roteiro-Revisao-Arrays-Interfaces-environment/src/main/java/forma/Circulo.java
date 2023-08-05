package forma;

import java.lang.Math;

public class Circulo implements Forma{
    
    private double raio;

    public Circulo(double raio){
        this.raio = raio;
    }

    @Override
    public double calculaArea() {
       return Math.sqrt(raio) * Math.PI; 
    }
    
}
