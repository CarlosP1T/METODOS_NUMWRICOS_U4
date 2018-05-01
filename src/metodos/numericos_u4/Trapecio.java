package metodos.numericos_u4;
import java.util.ArrayList;
public class Trapecio {
    double solucion;
    public ArrayList lista(double n, double limitA, double limitB,int invertir)
    {
        int puntos=-1;
        double suma=0, h=0;
        solucion=0;
        ArrayList<Atributos> datosLista=new ArrayList<>();
        while(puntos < n)
        {
            if(n<=2)
            {
                Atributos formu= new Atributos();
                puntos++; 
                formu.setAtributos(puntos);
                
                formu.setIncre((limitB-limitA)/2);
                if(invertir==0)
                {
                    formu.setFormula1(formu.getIncre()*(calculo(limitA)+calculo(limitB)));
                    formu.setFormula2(formu.getIncre()*(calculo(limitA)+calculo(limitB)));
                }
                else
                {
                    formu.setFormula1(formu.getIncre()*((-1*calculo(limitA))+(-1*calculo(limitB))));
                    formu.setFormula2(formu.getIncre()*((-1*calculo(limitA))+(-1*calculo(limitB))));
                }
                h= formu.getIncre();
                if((puntos)>0 & (puntos)<n)
                    suma+=formu.getFormula2();
                datosLista.add(formu);
            }
            if(n>2)
            {
                Atributos p= new Atributos();
                puntos++; 
                p.setAtributos(puntos);
                p.setIncre((limitB-limitA)/n);
                p.setFormula1(limitA+(p.getAtributos()*p.getIncre()));
                if(invertir==1)
                    p.setFormula2(-1*calculo(p.getFormula1()));
                else
                    p.setFormula2(calculo(p.getFormula1()));

                h= p.getIncre();
                if((puntos)>0 & (puntos)<n)
                    suma+=p.getFormula2();
                datosLista.add(p);
            }
                System.out.println( "suma  "+suma);
        }
        if(n<=2)
        {
            if(invertir==1)
                solucion= h*((-1*calculo(limitA))+(-1*calculo(limitB)));
            else
                solucion= h*((calculo(limitA))+(calculo(limitB)));
        }
        else
        {
            if(invertir==1)
                solucion= (h/2*((-1*calculo(limitA))+(2*suma)+(-1*calculo(limitB))));
            else
                solucion= (h/2*((calculo(limitA))+(2*suma)+(calculo(limitB))));
        }
        
        System.out.println(solucion);
        return datosLista;
    }
    public double getSolucion()
    {
        return solucion;
    }  
    public double calculo(double x)
    {
        return Math.pow(x, 2); //Elevar a la 2
    }   

    
}
