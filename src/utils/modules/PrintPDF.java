/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils.modules;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controllers.HomeController;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import services.TransactionService;
import services.TransactionServiceImpl;

/**
 *
 * @author kelvi
 */
public class PrintPDF {
    
    TransactionService transactionService; 
    int userId;
    
    /**
     * Constructor PrintPDF
     */
    public PrintPDF(){
        this.transactionService = new TransactionServiceImpl(JdbcUtils.getTransactionDao());
        this.userId = SessionManager.userId;
    }

    /**
     * Fungsi generate file
     * @param fileName
     * @return 
     */
    public boolean generate(String fileName) {

        try {
            
            HomeController homeController = new HomeController();

            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));

            document.open();

            Paragraph p = new Paragraph("Laporan Keuangan\n");
            document.add(p);
            
            p = new Paragraph("Saldo Awal : " + homeController.getBalance() + "\n");
            document.add(p);
            
            p = new Paragraph("Pemasukan : " + homeController.getIncome()+ "\n");
            document.add(p);
            
            p = new Paragraph("Pengeluaran : " + homeController.getOutcome()+ "\n");
            document.add(p);
            
            p = new Paragraph("Saldo Sekarang : " + homeController.getCurrentlyBalance() + "\n");
            document.add(p);
            
            p = new Paragraph(" ");
            document.add(p);
            
            PdfPTable table = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Jenis Transaksi"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Total"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Waktu"));
            table.addCell(c1);
            
            c1 = new PdfPCell(new Phrase("Deskripsi"));
            table.addCell(c1);
            
            table.setHeaderRows(1);
            
            transactionService.getTransactionByUserId(userId).stream().map((transactionByUserId) -> {
                table.addCell(transactionByUserId.getTransType());
                return transactionByUserId;
            }).map((transactionByUserId) -> {
                table.addCell(transactionByUserId.getTotalTrans() + "");
                return transactionByUserId;
            }).map((transactionByUserId) -> {
                table.addCell(transactionByUserId.getTime());
                return transactionByUserId;
            }).forEachOrdered((transactionByUserId) -> {
                table.addCell(transactionByUserId.getDescription());
            });
            
            document.add(table);

            document.close();
            
            return true;

        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(PrintPDF.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
}
