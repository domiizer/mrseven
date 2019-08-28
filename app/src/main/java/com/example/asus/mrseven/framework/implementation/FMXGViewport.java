/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.asus.mrseven.framework.implementation;

import com.example.asus.mrseven.framework.FMXGraphics;

/**
 *
 * @author User
 */
public class FMXGViewport {
    public double m_dViewX;
    public double m_dViewY;
    public double m_dViewZ;
    public double m_dDestWidth;
    public double m_dDestHeight;
    public double m_dDepthOfFieldX;
    public double m_dDepthOfFieldY;
    
    public FMXGViewport(double px, double py, double pz, double dofX, double dofY, double dw, double dh) {

        setViewPosition(px, py, pz);

        m_dDestWidth = dw;
        m_dDestHeight = dh;

        setDOF(dofX, dofY);

    }
    
    public double[] getViewPositionFromPos(double pos[]){
        double p[] = new double[3];
        if(pos==null){
            return p;
        }
        
        p[0] = (m_dDestWidth / 2) + (pos[0] - m_dViewX) * (m_dDepthOfFieldX);
        p[1] = (m_dDestHeight / 2) + (m_dViewY - pos[1]) * (m_dDepthOfFieldY);
        p[2] = pos[2];
        return p;
    }

    public void setViewPosition(double px, double py, double pz) {
        m_dViewX = px;
        m_dViewY = py;
        m_dViewZ = pz;
    }

    public void setDOF(double dofX, double dofY) {
        m_dDepthOfFieldX = dofX;
        m_dDepthOfFieldY = dofY;
    }

  /*  public void drawGrid(FMXGraphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.DARK_GRAY);
        int grid_size = 20;
        int startX = (int) (m_dViewX - (m_dDestWidth / 2) / m_dDepthOfFieldX);
        int endX = startX + (int) (m_dDestWidth / m_dDepthOfFieldX);
        // int startY = (int)((m_dViewY-m_dDestHeight/2)/m_dDepthOfFieldY);
        int startY = (int) (m_dViewY + (m_dDestHeight / 2) / m_dDepthOfFieldY);
        int endY = startY - (int) (m_dDestHeight / m_dDepthOfFieldY);
        // g2d.drawString((startY+0)+"", 100, 40);
        // g2d.drawString((endX+0)+"", 80, 40);
        int i, j;
        int x_count, y_count;
        Color color_g2 = new Color(0,0,0);
        for (i = startX, j = 0; i <= endX; i++) {
            if (i % grid_size == 0) {
                if (i % (grid_size*3) == 0) {
                    g2d.setColor(Color.DARK_GRAY);
                } else {
                    g2d.setColor(Color.DARK_GRAY);
                }
                // g2d.drawString(i+"",0, startY%40+(int)(j*20*m_dDepthOfFieldY));
                g2d.drawLine((int)m_dDestWidth-((int)(startX*m_dDepthOfFieldX) % (int) (grid_size * m_dDepthOfFieldX) + (int) (j * grid_size * m_dDepthOfFieldX)), 0,
                       (int)m_dDestWidth-((int)(startX*m_dDepthOfFieldX) % (int) (grid_size * m_dDepthOfFieldX) + (int) (j * grid_size * m_dDepthOfFieldX)), (int) m_dDestHeight);
                j++;
            }
            // }
        }
        x_count = j;
        for (i = startY, j = 0; i >= endY; i--) {
            if (i % grid_size == 0) {
                if (i % (grid_size*5) == 0) {
                    g2d.setColor(Color.RED);
                } else {
                    g2d.setColor(Color.DARK_GRAY);
                }
                // g2d.drawString(i+"",0, startY%40+(int)(j*20*m_dDepthOfFieldY));
                g2d.drawLine(0, (int)(startY*m_dDepthOfFieldY) % (int) (grid_size * m_dDepthOfFieldY) + (int) (j * grid_size * m_dDepthOfFieldY),
                        (int) m_dDestWidth, (int)(startY*m_dDepthOfFieldY) % (int) (grid_size * m_dDepthOfFieldY) + (int) (j * grid_size * m_dDepthOfFieldY));
                j++;
            }
        }
        y_count = j;

        
        
        Font font = new Font("Arial", Font.PLAIN, 16);
    
        g2d.setFont(font);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.GRAY);
        //for (i = startX, j = 0; i <= endX; i++) {
        for (i = endX, j = 0; i >= startX; i--) {
            if (i % (grid_size*3) == 0) {
                int stringLen = (int)g2d.getFontMetrics().getStringBounds("+", g2d).getWidth(); 
                g2d.drawString( "+", (int)m_dDestWidth-((int)(startX*m_dDepthOfFieldX) % (int) ((grid_size*3) * m_dDepthOfFieldX) + (int) (j * (grid_size*3) * m_dDepthOfFieldX))-stringLen/2, 30);
                j++;
            }
        }
        Font font2 = new Font("Arial", Font.PLAIN, 12);
        g2d.setColor(Color.RED);
        g2d.setFont(font2);
        for (i = startY, j = 0; i >= endY; i--) {
            if (i % (grid_size*5) == 0) {
                g2d.drawString((i/(grid_size*5))  + "", 2, (int)(startY*m_dDepthOfFieldY) % (int) ((grid_size*5) * m_dDepthOfFieldY) + (int) (j * (grid_size*5) * m_dDepthOfFieldY)-2);
                j++;
            }
        }
        
            
        // g2d.drawString(((int)m_dDestHeight-(startY+0))+"", 0, 80);
   
    }*/
}
