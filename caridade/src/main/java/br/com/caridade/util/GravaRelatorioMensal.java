package br.com.caridade.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.util.List;

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

import br.com.caridade.mensagem.RelatorioMensal;
import br.com.caridade.model.Instituicao;

public class GravaRelatorioMensal {
	
	public static PdfPTable doImage() throws BadElementException, MalformedURLException, IOException {
		
		PdfPTable table = new PdfPTable(1);
		table.setWidthPercentage(50);
		Image img = Image.getInstance("C:\\Users\\Alexandre\\git\\site\\caridade\\src\\main\\resources\\static\\image\\caridade.PNG");
		//Image img = Image.getInstance("/home/disdi/disdi.uh-app.com.br/webapps/caridade/WEB-INF/classes/static/image/caridade.PNG");
		img.scalePercent(4);
		//img.setAbsolutePosition(300f, 555f);//PARA COURIER
		PdfPCell itens = new PdfPCell(img, false);
		itens.setBorder(Rectangle.NO_BORDER);
		itens.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(itens);
		return table;
	}

	public static PdfPTable doHeader() throws DocumentException {
		//PdfPTable table = new PdfPTable(new float[] { 14f, 8f, 5f });
		PdfPTable table = new PdfPTable(new float[] { 14f, 8f });
		table.setWidthPercentage(50);

		Font f = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8);
		Font fwhite = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8);
		fwhite.setColor(BaseColor.WHITE);

		PdfPCell itens = new PdfPCell(new Phrase("Itens", f));
		itens.setHorizontalAlignment(Element.ALIGN_CENTER);
		itens.setBackgroundColor(new BaseColor(213, 243, 244));

		PdfPCell qtd = new PdfPCell(new Phrase("Quantidade", f));
		qtd.setHorizontalAlignment(Element.ALIGN_CENTER);
		qtd.setBackgroundColor(new BaseColor(213, 243, 244));

		/*
		 * PdfPCell peso = new PdfPCell(new Phrase("Peso gm", f));
		 * peso.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * peso.setBackgroundColor(new BaseColor(213, 243, 244));
		 */
		table.addCell(itens);
		table.addCell(qtd);
		//table.addCell(peso);

		return table;
	}
	
	public static PdfPTable doSum(Long qtd, Long peso) throws DocumentException {
		//PdfPTable table = new PdfPTable(new float[] { 14f, 8f, 5f });
		PdfPTable table = new PdfPTable(new float[] { 14f, 8f });
		table.setWidthPercentage(50);

		Font f = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8);
		Font fwhite = FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8);
		fwhite.setColor(BaseColor.WHITE);

		PdfPCell itens = new PdfPCell(new Phrase("", FontFactory.getFont(FontFactory.HELVETICA_BOLDOBLIQUE, 8)));
		itens.setBorder(Rectangle.NO_BORDER);
		itens.setHorizontalAlignment(Element.ALIGN_CENTER);

		PdfPCell celQtd = new PdfPCell(new Phrase(UtilsTools.formatNumber(qtd), f));
		celQtd.setHorizontalAlignment(Element.ALIGN_CENTER);
		celQtd.setBackgroundColor(new BaseColor(213, 243, 244));

		/*
		 * PdfPCell celPso = new PdfPCell(new Phrase(UtilsTools.formatNumber(peso), f));
		 * celPso.setHorizontalAlignment(Element.ALIGN_CENTER);
		 * celPso.setBackgroundColor(new BaseColor(213, 243, 244));
		 */

		table.addCell(itens);
		table.addCell(celQtd);
		//table.addCell(celPso);

		return table;
	}

	public static PdfPTable doDetalhTable() throws DocumentException {
		//PdfPTable table = new PdfPTable(new float[] { 14f, 8f, 5f });
		PdfPTable table = new PdfPTable(new float[] { 14f, 8f });
		table.setWidthPercentage(50);

		return table;
	}

	public void record(Instituicao instituicao, int mes, List<RelatorioMensal> ltRel) {

		float left = 10;
		float right = 10;
		float top = 20;
		float bottom = 0;
		Document document = new Document(PageSize.A4, left, right, top, bottom);
		//document.setPageSize(PageSize.A4.rotate());

		try {

			String fileName = "C:\\Users\\alexandre\\Documents\\relatorio_" + instituicao.getCodInstituicao() + ".pdf";
			//String fileName = "/home/disdi/disdi.uh-app.com.br/webapps/caridade/relatorio_"+instituicao.getCodInstituicao()+".pdf";
			File arq = new File(fileName);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(baos);

			PdfWriter.getInstance(document, new FileOutputStream(arq));
			// PdfWriter.getInstance(document, ps);
			document.open();
			document.add(new Paragraph(""));
			document.add(doImage());

			Font f1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);
			f1.setColor(BaseColor.BLACK);

			Paragraph first = new Paragraph("Paróquia Nossa Senhora de Lourdes", f1);
			first.setAlignment(1);
			first.setSpacingAfter(5);

			Paragraph second = new Paragraph("Doações Entregues pela Pastoral da Caridade à instituição "
					+ instituicao.getNome() + " no mês de " + UtilsTools.getNomeMes(mes) + ".", f1);
			second.setAlignment(1);
			second.setSpacingAfter(5);

			document.add(first);
			document.add(new Paragraph(""));
			document.add(new Paragraph(""));
			document.add(second);
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			document.add(doHeader());
			document.addAuthor("Alexandre Costa Duarte");
			PdfPTable table = doDetalhTable();

			BaseColor baseColor;
			int iCount = 0;
			Long lQtd = new Long(0);
			Long lPeso = new Long(0);
			for (RelatorioMensal relatoriMensal : ltRel) {
				Font f = FontFactory.getFont(FontFactory.HELVETICA, 8);
				f.setColor(new BaseColor(25, 40, 116));
				Font forte = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 8);
				forte.setColor(new BaseColor(25, 40, 116));
				iCount++;

				if (iCount % 2 == 0) {
					baseColor = new BaseColor(225, 228, 243);
				} else {
					baseColor = new BaseColor(253, 253, 253);
				}

				PdfPCell celulaItem = new PdfPCell(new Phrase(relatoriMensal.getItem(), forte));
				celulaItem.setHorizontalAlignment(Element.ALIGN_CENTER);
				celulaItem.setBackgroundColor(baseColor);

				PdfPCell celulaQtd = new PdfPCell(new Phrase(UtilsTools.formatNumber(relatoriMensal.getQuantidade()), forte));
				celulaQtd.setHorizontalAlignment(Element.ALIGN_CENTER);
				celulaQtd.setBackgroundColor(baseColor);
				lQtd += relatoriMensal.getQuantidade();

				
				//PdfPCell celulaPeso = new PdfPCell(new
				//Phrase(UtilsTools.formatNumber(relatoriMensal.getPeso()), forte));
				//celulaPeso.setHorizontalAlignment(Element.ALIGN_CENTER);
				//celulaPeso.setBackgroundColor(baseColor); lPeso += relatoriMensal.getPeso();
				 

				table.addCell(celulaItem);
				table.addCell(celulaQtd);
				//table.addCell(celulaPeso);
			}
			document.add(table);
			document.add(doSum(lQtd, lPeso));
			document.close();

		} catch (DocumentException de) {
			System.out.println(de.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	
}
