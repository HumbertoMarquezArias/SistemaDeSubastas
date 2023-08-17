import java.util.ArrayList;

public class Subasta
{
    private ArrayList<Lote> lotes;
    private int numeroDeLoteSiguiente;
    /**
     * crear una nueva subasta
     */
    public Subasta()
    {
        lotes =new ArrayList<Lote>();
        numeroDeLoteSiguiente=1;
    }
    /**
     * Ingresa nuevo lote en la subasta
     * @ param descripcion la descripcion del lote
     */
    public void ingresarLote(String descripcion)
    {
        lotes.add(new Lote(numeroDeLoteSiguiente, descripcion));
        numeroDeLoteSiguiente++;
    }
    /**
     * muestra la descripcion de todos los lotes de la subasta
     */
    public void mostrarLotes()
    {
        for(Lote lote : lotes)
        {
            System.out.println(lote.toString());
        }
    }
    
    public void ofertaPara(int numeroDeLote, Persona ofertante, long valor)
    {
        Lote loteElegido = getLote(numeroDeLote);
        boolean exito = false;
        
        if (loteElegido !=null)
        {
            exito = loteElegido.ofertaPara(new Oferta(ofertante, valor));
        }
        if(exito)
        {
            System.out.println("la oferta para el lote No "+numeroDeLote+ "resulto exitosa");
            
        }
        else
        {
            Oferta ofertaMaxima = loteElegido.getOfertaMaxima();
            System.out.println("el lote No "+numeroDeLote + " tiene una oferta de: "+ofertaMaxima.getMonto());
        }
    }
        
        public Lote getLote(int numeroDeLote)
        {
            if((numeroDeLote >=1)&&(numeroDeLote < numeroDeLoteSiguiente))
            {
               Lote loteElegido =lotes.get(numeroDeLote-1);
               
               if(loteElegido.getNumero() !=numeroDeLote)
               {
                   System.out.println("Error interno: se retorno el lote No.: "+loteElegido.getNumero()+" en lugar de" + numeroDeLote);
               }
               return loteElegido;
               
            }
            else
            {
                System.out.println("El lote numero: "+numeroDeLote+"no existe");
                return null;
            }
        }
        
        public void mostrarAdujicados()
        {
            for(Lote lote : lotes)
            {
                System.out.println(lote.mostrarGanador());
            }
        }
    
}   
    
    
    

