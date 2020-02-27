package br.com.caridade.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.caridade.dto.RelatorioDoacaoDTO;

	public class GravaRelatorioAnual {
		
		@Value("${JAVA_HOME}")
	    private String name;
	
	/*
	 * public static void main(String[] args) { GravaRelatorio grava = new
	 * GravaRelatorio(); RelatorioAnual relatorio; try { relatorio = new
	 * RelatorioAnual(new Long(2019)); grava.record(relatorio.getInstListJson()); }
	 * catch (JsonParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (InstantiationException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (SQLException e) { // TODO Auto-generated catch
	 * block e.printStackTrace(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * System.out.println("Gravou"); return; }
	 */
	public static PdfPTable doImage() throws BadElementException, MalformedURLException, IOException {
		
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(50);
		//Image img = Image.getInstance("C:\\Users\\Alexandre\\git\\site\\caridade\\src\\main\\resources\\static\\image\\caridade.PNG");
		Image img = Image.getInstance("/home/disdi/disdi.uh-app.com.br/webapps/caridade/WEB-INF/classes/static/image/caridade.PNG");
		img.scalePercent(4);
		//img.setAbsolutePosition(300f, 555f);//PARA COURIER
		PdfPCell itens = new PdfPCell(img, false);
		itens.setBorder(Rectangle.NO_BORDER);
		itens.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(itens);
		return table;
	}
	
	public static PdfPTable doHeader(Long ano) throws DocumentException {
		
		PdfPTable table = new PdfPTable(new float[] { 14f, 5f, 5f,5f,5f,5f,5f,5f,5f,5f,5f,5f,5f,5f });
		table.setWidthPercentage(90);
		Font f = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 6);
		Font fwhite = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 6);
		fwhite.setColor(BaseColor.WHITE);
		PdfPCell instName = new PdfPCell(new Phrase("",FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8)));
		instName.setBorder(Rectangle.NO_BORDER);
		instName.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell jan = new PdfPCell(new Phrase("Jan/"+ano,f));
		jan.setHorizontalAlignment(Element.ALIGN_CENTER);
		jan.setBackgroundColor(new BaseColor(213,243,244));
		
		PdfPCell fev = new PdfPCell(new Phrase("Fev/"+ano,f));
		fev.setHorizontalAlignment(Element.ALIGN_CENTER);
		fev.setBackgroundColor(new BaseColor(93,136,208));
		
		PdfPCell mar = new PdfPCell(new Phrase("Mar/"+ano,fwhite));
		mar.setHorizontalAlignment(Element.ALIGN_CENTER);
		mar.setBackgroundColor(new BaseColor(25,40,116));
		
		PdfPCell abr = new PdfPCell(new Phrase("Abr/"+ano,f));
		abr.setHorizontalAlignment(Element.ALIGN_CENTER);
		abr.setBackgroundColor(new BaseColor(213,243,244));
		
		PdfPCell mai = new PdfPCell(new Phrase("Mai/"+ano,f));
		mai.setHorizontalAlignment(Element.ALIGN_CENTER);
		mai.setBackgroundColor(new BaseColor(93,136,208));

		PdfPCell jun = new PdfPCell(new Phrase("Jun/"+ano,fwhite));
		jun.setHorizontalAlignment(Element.ALIGN_CENTER);
		jun.setBackgroundColor(new BaseColor(25,40,116));

		PdfPCell jul = new PdfPCell(new Phrase("Jul/"+ano,f));
		jul.setHorizontalAlignment(Element.ALIGN_CENTER);
		jul.setBackgroundColor(new BaseColor(213,243,244));

		PdfPCell ago = new PdfPCell(new Phrase("Ago/"+ano,f));
		ago.setHorizontalAlignment(Element.ALIGN_CENTER);
		ago.setBackgroundColor(new BaseColor(93,136,208));

		PdfPCell set = new PdfPCell(new Phrase("Set/"+ano,fwhite));
		set.setHorizontalAlignment(Element.ALIGN_CENTER);
		set.setBackgroundColor(new BaseColor(25,40,116));

		PdfPCell out = new PdfPCell(new Phrase("Out/"+ano,f));
		out.setHorizontalAlignment(Element.ALIGN_CENTER);
		out.setBackgroundColor(new BaseColor(213,243,244));

		PdfPCell nov = new PdfPCell(new Phrase("Nov/"+ano,f));
		nov.setHorizontalAlignment(Element.ALIGN_CENTER);
		nov.setBackgroundColor(new BaseColor(93,136,208));

		PdfPCell des = new PdfPCell(new Phrase("Des/"+ano,fwhite));
		des.setHorizontalAlignment(Element.ALIGN_CENTER);
		des.setBackgroundColor(new BaseColor(25,40,116));
		
		PdfPCell tot = new PdfPCell(new Phrase("TOTAL",f));
		tot.setHorizontalAlignment(Element.ALIGN_CENTER);
		tot.setBackgroundColor(new BaseColor(213,243,244));

		table.addCell(instName);
		table.addCell(jan);
		table.addCell(fev);
		table.addCell(mar);
		table.addCell(abr);
		table.addCell(mai);
		table.addCell(jun);
		table.addCell(jul);
		table.addCell(ago);
		table.addCell(set);
		table.addCell(out);
		table.addCell(nov);
		table.addCell(des);
		table.addCell(tot);
		
		return table;
	}
	
	public static PdfPTable doDetalhTable() throws DocumentException {
		PdfPTable table = new PdfPTable(new float[] { 14f, 2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f,2f,3f });
		table.setWidthPercentage(90);
		Font f = FontFactory.getFont(FontFactory.HELVETICA, 4);
        f.setColor(new BaseColor(48,63,89) );
        
        PdfPCell inst = new PdfPCell(new Phrase("INSTITUIÇÕES",FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8)));
        inst.setHorizontalAlignment(Element.ALIGN_CENTER);
		inst.setBackgroundColor(new BaseColor(213,243,244));
		
		PdfPCell cesta = new PdfPCell(new Phrase("Cestas básicas",f));
		cesta.setHorizontalAlignment(Element.ALIGN_CENTER);
		cesta.setBackgroundColor(new BaseColor(252,236,164));
		PdfPCell kg = new PdfPCell(new Phrase("Alimentos entregues (em Kg)",f));
		kg.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		table.addCell(inst);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		table.addCell(cesta);
		table.addCell(kg);
		
		return table;
	}
	
	public void record(List<RelatorioDoacaoDTO> ltRel) {
		
		float left = 0;
        float right = 0;
        float top = 20;
        float bottom = 0;
		Document document = new Document(PageSize.A4, left, right, top, bottom);
		document.setPageSize(PageSize.A4.rotate());
	      try {

	              //String fileName = "C:\\Users\\alexandre\\Documents\\relatorio.pdf";
	              String fileName = "/home/disdi/disdi.uh-app.com.br/webapps/caridade/relatorio.pdf";
	              File arq = new File(fileName);
	              
	              ByteArrayOutputStream baos = new ByteArrayOutputStream();
	              PrintStream ps = new PrintStream(baos);
	              
	              PdfWriter.getInstance(document, new FileOutputStream(arq));
	              //PdfWriter.getInstance(document, ps);
	              document.open();
	              System.out.println("DEBUG - file :"+fileName);
	              System.out.println("DEBUG - Name :"+name);
	              
				
			/*
			 * String imagemArq = "image/caridade.ico"; ImageData dataImg =
			 * ImageDataFactory.create(imagemArq); Image img = new Image(dataImg);
			 */
	              document.add(new Paragraph(""));
	              document.add(doImage());
				 
	              
	              Iterator<RelatorioDoacaoDTO> itRel = ltRel.iterator();
	              Long ano = new Long(2019);
	              
	              if ( ltRel.size() > 0 && 
	            	   ltRel.get(0) != null ) {
	            	  ano = ltRel.get(0).getAno(); 
	              }
	              
	              //Font f1 = FontFactory.getFont(FontFactory.COURIER_BOLD, 8);
	              Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
	              f1.setColor(BaseColor.BLACK);
	              
	              Paragraph first = new Paragraph("Paróquia Nossa Senhora de Lourdes",f1);
	              first.setAlignment(1);
	              first.setSpacingAfter(5);
	              
	              Paragraph second = new Paragraph("Doações Entregues pela Pastoral da Caridade - "+ano,f1);
	              second.setAlignment(1);
	              second.setSpacingAfter(5);
	              
	              document.add(first);
	              document.add(second);
	              
	              
	              document.add(doHeader(ano));
	              PdfPTable table = doDetalhTable();
	              
	              document.addAuthor("Alexandre Costa Duarte");
	              BaseColor baseColor, baseColorCesta;
	              int  iCount = 0;
	              Long totalAno = new Long(0);
	              Long totalAno12 = new Long(0);
	              while ( itRel.hasNext() ) {
	            	RelatorioDoacaoDTO relatorio = itRel.next();
		            Font f = FontFactory.getFont(FontFactory.HELVETICA, 4);
		            f.setColor(new BaseColor(25,40,116));
		            Font forte = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 4);
		            forte.setColor(new BaseColor(25,40,116));
	            	iCount++;
	            	
	            	if ( iCount % 2 == 0 ) {
	            		baseColorCesta = baseColor  = new BaseColor(225,228,243);
	            	} else {
	            		baseColorCesta = baseColor  = new BaseColor(253,253,253);
	            	}
	            	if ( ltRel.size() == iCount ) {
	            		f = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 4);
	            		forte = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 4);
	            		f.setColor(BaseColor.BLACK);
	            		forte.setColor(BaseColor.BLACK);
	            		baseColor = new BaseColor(213,243,244);
	            		baseColorCesta  = new BaseColor(201,191,170);
	            	}
	            	Long lJan = (relatorio.getJan() != null ? relatorio.getJan(): 0);
	            	Long lFev = (relatorio.getFev() != null ? relatorio.getFev(): 0);
	            	Long lMar = (relatorio.getMar() != null ? relatorio.getMar(): 0);
	            	Long lAbr = (relatorio.getAbr() != null ? relatorio.getAbr(): 0);
	            	Long lMai = (relatorio.getMai() != null ? relatorio.getMai(): 0);
	            	Long lJun = (relatorio.getJun() != null ? relatorio.getJun(): 0);
	            	Long lJul = (relatorio.getJul() != null ? relatorio.getJul(): 0);
	            	Long lAgo = (relatorio.getAgo() != null ? relatorio.getAgo(): 0);
	            	Long lSet = (relatorio.getSet() != null ? relatorio.getSet(): 0);
	            	Long lOut = (relatorio.getOut() != null ? relatorio.getOut(): 0);
	            	Long lNov = (relatorio.getNov() != null ? relatorio.getNov(): 0);
	            	Long lDez = (relatorio.getDec() != null ? relatorio.getDec(): 0);
	            	
	            	totalAno = lJan +
	            			   lFev +
	            			   lMar +
	            			   lAbr +
	            			   lMai +
	            			   lJun +
	            			   lJul +
	            			   lAgo +
	            			   lSet +
	            			   lOut +
	            			   lNov +
	            			   lDez ;
	            	
	            	totalAno12 = ( lJan/12 ) + 
	            			     ( lFev/12 ) +
	            			     ( lMar/12 ) +
	            			     ( lAbr/12 ) +
	            			     ( lMai/12 ) +
	            			     ( lJun/12 ) +
	            			     ( lJul/12 ) +
	            			     ( lAgo/12 ) +
	            			     ( lSet/12 ) +
	            			     ( lOut/12 ) +
	            			     ( lNov/12 ) +
	            			     ( lDez/12 ) ;
	            	
	          		PdfPCell celulaNome = new PdfPCell(new Phrase(relatorio.getInstituicao(),forte));
	          		celulaNome.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		celulaNome.setBackgroundColor(baseColor);
	          		
	          		
	          		PdfPCell jan = new PdfPCell(new Phrase(UtilsTools.formatNumber(lJan),f));
	          		jan.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		jan.setBackgroundColor(baseColor);
	          		PdfPCell jan2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lJan/12))),f));
	          		jan2.setHorizontalAlignment(Element.ALIGN_CENTER);
          			jan2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell fev = new PdfPCell(new Phrase(UtilsTools.formatNumber(lFev),f));
	          		fev.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		fev.setBackgroundColor(baseColor);
	          		PdfPCell fev2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lFev/12))),f));
	          		fev2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		fev2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell mar = new PdfPCell(new Phrase(UtilsTools.formatNumber(lMar),f));
	          		mar.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		mar.setBackgroundColor(baseColor);
	          		PdfPCell mar2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lMar/12))),f));
	          		mar2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		mar2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell abr = new PdfPCell(new Phrase(UtilsTools.formatNumber(lAbr),f));
	          		abr.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		abr.setBackgroundColor(baseColor);
	          		PdfPCell abr2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lAbr/12))),f));
	          		abr2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		abr2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell mai = new PdfPCell(new Phrase(UtilsTools.formatNumber(lMai),f));
	          		mai.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		mai.setBackgroundColor(baseColor);
	          		PdfPCell mai2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lMai/12))),f));
	          		mai2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		mai2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell jun = new PdfPCell(new Phrase(UtilsTools.formatNumber(lJun),f));
	          		jun.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		jun.setBackgroundColor(baseColor);
	          		PdfPCell jun2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lJun/12))),f));
	          		jun2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		jun2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell jul = new PdfPCell(new Phrase(UtilsTools.formatNumber(lJul),f));
	          		jul.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		jul.setBackgroundColor(baseColor);
	          		PdfPCell jul2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lJul/12))),f));
	          		jul2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		jul2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell ago = new PdfPCell(new Phrase(UtilsTools.formatNumber(lAgo),f));
	          		ago.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		ago.setBackgroundColor(baseColor);
	          		PdfPCell ago2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lAgo/12))),f));
	          		ago2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		ago2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell set = new PdfPCell(new Phrase(UtilsTools.formatNumber(lSet),f));
	          		set.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		set.setBackgroundColor(baseColor);
	          		PdfPCell set2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lSet/12))),f));
	          		set2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		set2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell out = new PdfPCell(new Phrase(UtilsTools.formatNumber(lOut),f));
	          		out.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		out.setBackgroundColor(baseColor);
	          		PdfPCell out2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lOut/12))),f));
	          		out2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		out2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell nov = new PdfPCell(new Phrase(UtilsTools.formatNumber(lNov),f));
	          		nov.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		nov.setBackgroundColor(baseColor);
	          		PdfPCell nov2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lNov/12))),f));
	          		nov2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		nov2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell des = new PdfPCell(new Phrase(UtilsTools.formatNumber(lDez),f));
	          		des.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		des.setBackgroundColor(baseColor);
	          		PdfPCell des2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(new Long(Math.abs(lDez/12))),f));
	          		des2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		des2.setBackgroundColor(baseColorCesta);
	          		
	          		PdfPCell tot = new PdfPCell(new Phrase(UtilsTools.formatNumber(totalAno),forte));
	          		tot.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		tot.setBackgroundColor(baseColor);
	          		PdfPCell tot2 = new PdfPCell(new Phrase(UtilsTools.formatNumber(totalAno12),forte));
	          		tot2.setHorizontalAlignment(Element.ALIGN_CENTER);
	          		tot2.setBackgroundColor(baseColorCesta);
	          		
	          		table.addCell(celulaNome);
	        		table.addCell(jan2);
	        		table.addCell(jan);
	        		table.addCell(fev2);
	        		table.addCell(fev);
	        		table.addCell(mar2);
	        		table.addCell(mar);
	        		table.addCell(abr2);
	        		table.addCell(abr);
	        		table.addCell(mai2);
	        		table.addCell(mai);
	        		table.addCell(jun2);
	        		table.addCell(jun);
	        		table.addCell(jul2);
	        		table.addCell(jul);
	        		table.addCell(ago2);
	        		table.addCell(ago);
	        		table.addCell(set2);
	        		table.addCell(set);
	        		table.addCell(out2);
	        		table.addCell(out);
	        		table.addCell(nov2);
	        		table.addCell(nov);
	        		table.addCell(des2);
	        		table.addCell(des);
	        		table.addCell(tot2);
	        		table.addCell(tot);
	              }
	              document.add(table);
	              System.out.println("Closing");
	              document.close();
	              System.out.println("Closed");
	              if (Desktop.isDesktopSupported()) {
	  				Desktop.getDesktop().open(arq);
	  			} else {
	  				System.out.println("Awt Desktop is not supported!");
	  			}
	          
	      }catch(DocumentException de) {
	          System.out.println(de.getMessage());
	      }catch(IOException ioe) {
	          System.out.println(ioe.getMessage());
	      }
	}
}
