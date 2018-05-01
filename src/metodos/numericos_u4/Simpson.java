package metodos.numericos_u4;

import java.util.ArrayList;
import java.util.Scanner;

public class Simpson {
     double solucion;
    public ArrayList lista(double n, double a, double b, int invertir)
    {
        int puntos=-1;
        double sumaPar=0,sumaImpar=0,h=0; 
        solucion=0;    
        ArrayList<Atributos> datosLista=new ArrayList<>();
        while(puntos < n)
        {
            puntos++;  
            Atributos formu= new Atributos();
            
            formu.setAtributos(puntos);
            formu.setIncre((b-a)/n);
            formu.setFormula1(a+(formu.getAtributos()*formu.getIncre()));
            
            if(invertir==0)
                formu.setFormula2(calculo(formu.getFormula1()));
            if(invertir==1)
                formu.setFormula2(-1*calculo(formu.getFormula1()));
            
            h= formu.getIncre();
            if((puntos)%2==0)
            {
                if((puntos)>0 & (puntos-1)<n)
                    sumaPar+=formu.getFormula2();
                
            }else
            {
                if((puntos)>0 & (puntos-1)<n)
                    sumaImpar+=formu.getFormula2();
            }
            
            datosLista.add(formu);
        }
        if(invertir==0)
            solucion= (h/3*(calculo(a)+(4*sumaImpar)+(2*sumaPar)+calculo(b)));
        else
            solucion= (h/3*((-1*calculo(a))+(4*sumaImpar)+(2*sumaPar)+(-1*calculo(b))));
        System.out.println(solucion);
        return datosLista;
    }
    public double getSolucion()
    {
        return solucion;
    }
    
    public double calculo(double x)
    {
        return (x/(Math.sqrt((4-Math.pow(x, 2)))));
    }
  
    
}
