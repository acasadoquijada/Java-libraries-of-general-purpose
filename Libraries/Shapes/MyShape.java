import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 * @author Alejandro Casado Quijada
 */

public abstract class MyShape {
    
    
    /**
     * Color object that indicates the stroke color
     * @since Version 1.00
     */
    
    protected Color stroke_color;
    
      /**
     * Color object that indicates the fill color 1
     * @since Version 1.00
     */
    
    protected Color fill_color_1;
    
            /**
     * Color object that indicates the fill color 2
     * @since Version 1.00
     */
    
    protected Color fill_color_2;
    
     /**
     * Stroke object that represents the stroke
     * @since Version 1.00
     */
    
    protected Stroke stroke;

     /**
	 * An integer indicating the type of line
	 * can be continuous or discontinuous
     * @since Version 1.00
     */
    
    protected int type_of_line;
    
     /**
	 * Integer indicating the type of filling.
     * Being able to be unfilled, filled, horizontal gradient fill or
     * vertical, left or right diagonal, radial reflect or repeat
     * @since Version 1.00
     */
    
    protected int fill_type;
    
    /**
     * Boolean indicating whether or not there is smoothed in the figure.
     * @since Version 1.00
     */
    
    protected boolean smoothing;
    
    /**
     * Boolean indicating whether or not there is transparency in the figure
     * @since Version 1.00
     */
    
    protected boolean enabled_transparency;
    
     /**
     * float indicating the value of transparency.
     * @since Version 1.00
     */
    protected float value_of_transparency;
   
    /**
     * integer that represents the stroke.
     * @since Version 1.00
     */
    
    protected int thickness_of_the_stroke;
     
	/**
     * Composite Object used for transparency.
     * @since Version 1.00
     */
    
    protected Composite c;
    
        
	 /**
     * Integer indicating the type of line is continuous.
     * @since Version 1.00
     */
    
    public static final int CONTINUOUS_LINE = 0;
    
     /**
     * Integer indicating the type of line is discontinuous.
     * @since Version 1.00
     */
    public static final int DISCONTINUOUS_LINE = 1;

   

    /**
     * Constructor.
     * @since version 1.00
     */
    
    public MyShape(){
        this.smoothing = false;
        this.enabled_transparency = false;
        this.stroke_color = Color.BLACK;
        this.fill_color_1 = Color.RED;
        this.fill_color_2 = Color.GREEN;
        this.thickness_of_the_stroke = 1;
        this.type_of_line = 0;
        this.fill_type = 0;
        this.value_of_transparency = 0.5F;
        this.stroke = new BasicStroke();
    }

     /**
     * Parameterized constructor.
     * @param Color object that indicates the stroke color
     * @param integer that represents the stroke
     * @param an integer indicating the type of line
     * @param boolean indicating whether or not there is smoothed in the figure
     * @param Boolean indicating whether or not there is transparency in the figure
     * @param float indicating the value of transparency
     * @since version 1.00
     */
    
    public MyShape(Color stroke_color, int thickness_of_the_stroke, int type_of_line, boolean smoothing,
            boolean enabled_transparency,float value_of_transparency){
        
        this.stroke_color = stroke_color;
        this.thickness_of_the_stroke = thickness_of_the_stroke;
        this.type_of_line = type_of_line;
        this.smoothing = smoothing;
        this.enabled_transparency = enabled_transparency;
        this.value_of_transparency = value_of_transparency;
    }
     /**
     * Parameterized constructor.
     * @param Color object that indicates the stroke color
     * @param Color object that indicates the fill color 1
     * @param Color object that indicates the fill color 2
     * @param integer that represents the stroke
     * @param an integer indicating the type of line
     * @param boolean indicating whether or not there is smoothed in the figure
     * @param Boolean indicating whether or not there is transparency in the figure
     * @param float indicating the value of transparency
     * @since version 1.00
     */


    public MyShape(Color color, Color fill_color_1, Color fill_color_2, 
            int thickness_of_the_stroke, int type_of_line,int fill_type, boolean smoothing,
            boolean enabled_transparency,float value_of_transparency){
        
        this.stroke_color = color;
        
        this.thickness_of_the_stroke = thickness_of_the_stroke;
        
        this.type_of_line = type_of_line;
        this.fill_type = fill_type;
        
        this.fill_color_1 = fill_color_1;
        this.fill_color_2 = fill_color_2;
        
        this.value_of_transparency = value_of_transparency;

        if(thickness_of_the_stroke >= 1 && this.type_of_line == CONTINUOUS_LINE)
            this.stroke = new BasicStroke(thickness_of_the_stroke);
        else if(thickness_of_the_stroke >= 1 && this.type_of_line == DISCONTINUOUS_LINE){
            float []dash={ 25.0f, 25.0f };
            this.stroke = new BasicStroke(thickness_of_the_stroke,BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,1.0f,dash,0.0f);
        }
        this.smoothing = smoothing;
        this.enabled_transparency = transparencia;

    }
    
    /** 
     * Set the stroke color.
     * @param c Object Color that indicates the stroke color
     */
    
    public void setStroke_color(Color c){
        this.stroke_color = c;
    }

     /** 
     * Set the thickness of the stroke.
     * @param thickness int that indicates the thickness of the stroke
     */
    
    public void setThicknessStroke(int thickness){
        
        this.thickness_of_the_stroke = thickness;

    }
    
     /** 
     * Set the type line of the stroke.
     * @param type_of_line int that indicates the type of line
     */
    
    public void setTypeLine(int type_of_line){
        
        this.type_of_line = type_of_line;
        
        
    }
    
    /** 
     * enable / disable smoothing.
     * @param a boolean that enable / disable smoothing
     */
    
    public void setSmoothing(boolean a){
        this.smoothing = a;
    }
    
    
    /** 
     * on / off transparency.
     * @param t boolean that on / off transparency
     */
    
    public void setTransparency(boolean t){
        this.enabled_transparency = t;
    }

    /** 
     * Set the type of filling.
     * @param t int that indicates the type of filling
     */
    
    
    public void setTypeFilling(int t){
        
        this.fill_type = t;
    }
    
    /**
     * Set the fill color 1.
     * @param c Color object that indicates the fill color 1
     */
    
    public void setFillColor1(Color c){
        
        this.fill_color_1 = c;
    }

   /**
     * Set the fill color 2.
     * @param c Color object that indicates the fill color 2
     */
    
    public void setFillColor2(Color c){
        
        this.fill_color_2 = c;
    }
    
    
    /** 
     * Set the value of the transparency.
     * @param f float that indicates the value of the transparency
     */
    
    public void setValueTransparency(float f){
        this.value_of_transparency = f;
    }

    /**
     * Returns stroke color
     * @return stroke_color, object that indicates the color of the stroke
     */
    
    public Color getStrokeColor(){
        return this.stroke_color;
    }
    
    /**
     * Return the stroke
     * @return stroke, object BasicStroke that represents the stroke
     */
    
    
    public Stroke getStroke(){
        return this.stroke;
    }
     
	/**
     * Returns the thickness of the stroke
     * @return thickness of the stroke, float that indicates the thickness of the stroke 
     */
    
    
    public float getThicknessStroke(){
        return this.thickness_of_the_stroke;
    }

    /**
     * Returns smoothing
     * @return smoothing, boolean that indicates smoothing on/off
     */
    
    public boolean getsmoothing(){
        return this.smoothing;
    }

    /**
     * Returns on / off transparency
     * @return enabled_transparency, boolean on / off transparency
     */
    
    public boolean getTransparency(){
        return this.enabled_transparency;
    }
   
    
    /**
     * Returns the fill type
     * @return fill_type, int that indicates the fill type
     */
    
    public int getFillType(){
        
        return fill_type;
    }
    
    /**
     * Returns the fill color 1
     * @return fill_color_1, object Color that indicates the fill color 1
     */
    
    public Color getFillColor1(){
        
        return fill_color_1;
    }
    
    /**
     * Returns the fill color 2
     * @return fill_color_2, object Color that indicates the fill color 2
     */
    
    
    public Color getFillColor2(){
        
        return fill_color_2;
    }
    
        /**
     * Devuelve el valor de la transparencia
     * @return value_of_transparency, float que indica el valor de la transparencia
     */
    
    
    public float getValorTransparencia(){
        
        return value_of_transparency;
    }
  
    /**
     * Draw.
     * This method provides a number of common features in all child classes
     * as the stroke color, type of thickness, transparency .....
     * for child classes only have to draw their figures, 
	 * without having to worry about setting the features mentioned above
     * @param g2d object Graphics2D
     */
    
    public void draw(Graphics2D g2d){
       
       	
        if(thickness_of_the_stroke >= 1 && this.type_of_line == CONTINUOUS_LINE){
            this.stroke = new BasicStroke(thickness_of_the_stroke);
        }
        
        else if(thickness_of_the_stroke >= 1 && this.type_of_line == DISCONTINUOUS_LINE){
            float []dash={ 25.0f, 25.0f };
            this.stroke = new BasicStroke(thickness_of_the_stroke,BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER,1.0f,dash,0.0f);

        }

        g2d.setStroke(stroke);
        
                
        if(stroke_color != null)
            g2d.setColor(stroke_color);
                        
        
        if(enabled_transparency){
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    value_of_transparency));
        }
        else{
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    1F));         
        }
        
        
        
    
        if(smoothing){
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_ON);
        }
        
        else{
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    RenderingHints.VALUE_ANTIALIAS_OFF);
        }
    }
    
    /**
     * Paint boundingBox.
     * This method follows a philosophy similar to the method draw, 
	 * sets the color and thickness of boundingBox for child classes
 	 * only have to draw
     * @param g2d object Graphics2D
     */
    
    public void paintBoundingBox(Graphics2D g2d){
        g2d.setColor(Color.magenta);
        
        BasicStroke bs = new BasicStroke(1);
        
        g2d.setStroke(bs);
    }
    
    /**
     * Edit shape.	
	 * Abstract method to edit a shape with reference points
     * passed by parameter
     * @param p1 object Point2D
     * @param p2 object Point2D
     */
     public abstract void setFrameFromDiagonal(Point2D p1, Point2D p2); 
            
     /**
      * Moves shape.
	  * Abstract method to move a shape with reference to the
      * point parameter
      * @param pos object Point2D where the shape will move
      */
     
    public abstract void setLocation(Point2D pos);

    /**
      * Check point.
	  * Abstract method that checks if there is a figure in the point
      * by parameter
      * @param p object Point2D 
      * @return true if the point is part of a shape y false otherwise
      */
    
    public abstract boolean contains(Point2D p);
    

    
    
}
