import javax.swing.JOptionPane;
// esta clase solo es para leer datos por eso esta en español :(
public class clsGenerales{

    public clsGenerales(){

   
    }
    public void mensaje(String texto){
        JOptionPane.showMessageDialog(null, texto);
    }
    public int leerEntero(String texto){
        try{
            return Integer.parseInt(JOptionPane.showInputDialog(null, texto));
        }
        catch(Exception ex){
           return  leerEntero("Error, tipo de dato entero no valido");
        }

    }
    public float leerReal_f (String texto){
        try{
            return Float.parseFloat(JOptionPane.showInputDialog(null, texto));
        }
        catch(Exception ex){
            mensaje("Error, tipo de dato no valido");
        return 0;
        }
    }
    public String leerCadena(String texto){
        return JOptionPane.showInputDialog(null, texto).trim();
    }
    public int leerEnteroPos(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser entero mayor o igual a cero, reintente por favor");
            return leerEnteroPos(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroPos(Texto);
    }
}

public int leerEnteroPosMy0(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato > 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser entero mayor a cero, reintente por favor");
            return leerEnteroPosMy0(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroPosMy0(Texto);
    }
}

public int leerEnteroNeg(String Texto)
{
    try
    {
        int Dato = Integer.parseInt(JOptionPane.showInputDialog(null, Texto));
        if (Dato < 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser entero negativo (<0), reintente por favor");
            return leerEnteroNeg(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerEnteroNeg(Texto);
    }
}

public float leerRealPos_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser decimal mayor o igual a cero, reintente por favor");
            return leerRealPos_f(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerRealPos_f(Texto);
    }
}

public float leerRealPosMy0_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato > 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser decimal mayor a cero, reintente por favor");
            return leerRealPosMy0_f(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerRealPosMy0_f(Texto);
    }
}

public float leerRealNeg_f(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato < 0)
            return Dato;
        else
        {
            mensaje("Valor no válido, debe ser decimal negativo, reintente por favor");
            return leerRealNeg_f(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerRealNeg_f(Texto);
    }
}

public String leerCadena2(String Texto)
{
    String Dato = JOptionPane.showInputDialog(null, Texto).trim();

    if (Dato.isEmpty())
    {
        mensaje("Valor no válido, debe ser cadena diferente de vacío, reintente por favor");
        return leerCadena2(Texto);
    }
    else
        return Dato;
}

public float leerNota_05(String Texto)
{
    try
    {
        float Dato = Float.parseFloat(JOptionPane.showInputDialog(null, Texto));
        if (Dato >= 0 && Dato <= 5)
            return Dato;
        else
        {
            mensaje("Nota no válida, debe ser decimal entre 0 y 5 inclusive, reintente por favor");
            return leerNota_05(Texto);
        }
    }
    catch (Exception ex)
    {
        mensaje("Error. Tipo de dato o valor no válido");
        return leerNota_05(Texto);
    }
}
   
}