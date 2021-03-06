/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import conectar.conectar;
import java.sql.ResultSet;
import ProductosBL.productoBL;
/*
 *
 * @author fliza
 */
public class AgregarProducto extends javax.swing.JFrame {

    /**
     * Creates new form AgregarProducto
     */
    public AgregarProducto() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Agregar Producto");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Txtcategoria = new javax.swing.JTextField();
        Txtnombreproducto = new javax.swing.JTextField();
        Txtid = new javax.swing.JTextField();
        Txtmarca = new javax.swing.JTextField();
        Txtprecio = new javax.swing.JTextField();
        Txtcantidad = new javax.swing.JTextField();
        brnguardarproducto = new javax.swing.JButton();
        btncancelarproducto = new javax.swing.JButton();

        Txtcategoria.setText("Categoria");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Txtnombreproducto.setText("NombreProducto");
        Txtnombreproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtnombreproductoActionPerformed(evt);
            }
        });

        Txtid.setText("IdProducto");

        Txtmarca.setText("CategoriaProducto");
        Txtmarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtmarcaActionPerformed(evt);
            }
        });

        Txtprecio.setText("PrecioProducto");

        Txtcantidad.setText("StockProducto");

        brnguardarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proyecto/icono guardar producto.PNG"))); // NOI18N
        brnguardarproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnguardarproductoActionPerformed(evt);
            }
        });

        btncancelarproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proyecto/icono calcelar producto.PNG"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txtcantidad)
                    .addComponent(Txtprecio)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(brnguardarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addComponent(btncancelarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))
                            .addComponent(Txtmarca)
                            .addComponent(Txtid)
                            .addComponent(Txtnombreproducto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(108, 108, 108))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Txtnombreproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(brnguardarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelarproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void brnguardarproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnguardarproductoActionPerformed
  
        // TODO add your handling code here:
         conectar objconectar= new conectar(); 
          
         productoBL oproducto= recuperarDatosGUI();
          
       String srtSentenciaInsert= String.format("INSERT into productos (NombreProducto , idProducto, CategoriaProducto,PrecioProducto,StockProducto)"
                + "VALUES ( '%s',null, '%s','%s','%s')",oproducto.getNombreProducto(),oproducto.getCategoriaProducto(),oproducto.getPrecioProducto(),oproducto.getStockProducto() );
      objconectar.ejecutarsentenciaSQL(srtSentenciaInsert);
        try{
                  ResultSet resultado= objconectar.consultarRegistros("SELECT * FROM productos ");
                    
                   while (resultado.next())   {                    
                        System.out.println(resultado.getString("NombreProducto"));
                        System.out.println(resultado.getString("idProducto"));
                       System.out.println(resultado.getString("CategoriaProducto"));
                      System.out.println(resultado.getString("PrecioProducto"));
                       System.out.println(resultado.getString("StockProducto"));
                       

              
         }
                    
                }catch(Exception e){
                    System.out.println(e);
                
                
         }
    }//GEN-LAST:event_brnguardarproductoActionPerformed
public void mostrarDatos(){
    
    
    
}
    private void TxtnombreproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtnombreproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtnombreproductoActionPerformed

    private void TxtmarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtmarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtmarcaActionPerformed

    public productoBL recuperarDatosGUI(){
        productoBL oproductoBL=new productoBL();
         int idProducto=(Txtid.getText().isEmpty())?0:Integer.parseInt(Txtid.getText());
     int PrecioProducto= Integer.parseInt(Txtprecio.getText());
     int StockProducto= Integer.parseInt(Txtcantidad.getText());
         
  oproductoBL.setNombreProducto(Txtnombreproducto.getText());
  oproductoBL.setIdProducto(idProducto);
  oproductoBL.setCategoriaProducto(Txtcategoria.getText());
  oproductoBL.setPrecioProducto(PrecioProducto);
  oproductoBL.setStockProducto(StockProducto);
        
   return oproductoBL;
    }

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarProducto().setVisible(true);
             
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Txtcantidad;
    public javax.swing.JTextField Txtcategoria;
    public javax.swing.JTextField Txtid;
    public javax.swing.JTextField Txtmarca;
    public javax.swing.JTextField Txtnombreproducto;
    public javax.swing.JTextField Txtprecio;
    public javax.swing.JButton brnguardarproducto;
    public javax.swing.JButton btncancelarproducto;
    // End of variables declaration//GEN-END:variables
}
