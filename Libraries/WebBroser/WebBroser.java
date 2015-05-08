
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



// Fount  http://stackoverflow.com/questions/5226212/how-to-open-the-default-webbrowser-using-java
public class WebBroser {
    
    String url,os;
    Runtime rt;
    
    public WebBroser(){
        this.rt = Runtime.getRuntime();
        this.OS();
        
    }
    
    public WebBroser(String u){
        this.url = u;
        this.rt = Runtime.getRuntime();
        this.OS();

    }
    
    public String getUrl(){
        return this.url;
    }
    
    public void setUrl(String u){
        this.url = new String(u);
    }
    
    private void OS(){
        String aux = System.getProperty("os.name").toLowerCase();
        
        if(aux.contains("win"))
            os = "win";
        else if(aux.contains("mac"))
            os = "mac";
        else if(aux.contains("nix") || aux.contains("nux"))
            os ="linux";
        
    }
    private void open(String u){
        switch (os) {
            case "win":
             {
                 try {
                     this.rt.exec( "rundll32 url.dll,FileProtocolHandler " + u);
                 } catch (IOException ex) {
                     Logger.getLogger(WebBroser.class.getName()).log(Level.SEVERE, null, ex);
                 }       break;
             }

            case "mac":
             {
                 try {
                     this.rt.exec( "open" + u);
                 } catch (IOException ex) {
                     Logger.getLogger(WebBroser.class.getName()).log(Level.SEVERE, null, ex);
                 }       break;
             }

            case "linux":
             {
                 String[] browsers = {"epiphany", "firefox", "mozilla", "konqueror",
                              "netscape","opera","links","lynx"};

                 StringBuilder cmd = new StringBuilder();
                 for (int i=0; i<browsers.length; i++)
                 cmd.append(i==0  ? "" : " || ").append(browsers[i]).append(" \"").append(u).append( "\" ");
                 try {
                 this.rt.exec(new String[] { "sh", "-c", cmd.toString() });
                 } catch (IOException ex) {
                 Logger.getLogger(WebBroser.class.getName()).log(Level.SEVERE, null, ex);
                 }

             }
        } 
    }
    
    public void openURL(String u){
        
        if(u != null)
            this.open(u);
        else
            this.open(this.url);
    }
    
}
