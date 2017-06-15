
/**
 * Enumeration class Bando - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Bando
{
    CRISTIANO("Cristiano"), TURCO("Turco");
    
    private String bando;
    
    Bando(String bando)
    {
        this.bando = bando;
    }
    
    public String getBando()

    {
        return bando;
    }
}
