package com.snoopconsulting.antecedentes.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Service;

import com.google.common.collect.Iterables;
import com.snoopconsulting.antecedentes.domain.AntecedenteProyecto;
import com.snoopconsulting.antecedentes.poi.CustomXWPFDocument;
import com.snoopconsulting.antecedentes.web.form.CamposReporte;

@Service
public class ReportesService implements MessageSourceAware{
	
	@Value("${reporte.template.path}")
	private String templateFilePath;
	
	private MessageSource messageSource;
	
	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;		
	}
	
	public CustomXWPFDocument generarWord(List<AntecedenteProyecto> antecedentes, CamposReporte campos, Locale locale) throws
			FileNotFoundException, IOException, InvalidFormatException  {
		
		File srcFile = new File(templateFilePath);
		
		CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(srcFile));
		
		for (AntecedenteProyecto antecedente : antecedentes) {		
			XWPFParagraph paragraph = document.createParagraph();
			paragraph.setStyle("Ttulo3");
			
			XWPFRun run = paragraph.createRun();
			run.setBold(true);
			run.setText(messageSource.getMessage("reporte_proyecto", null, locale) + " ");
			run.setColor("0000ff");			
			XWPFRun run2 = paragraph.createRun();
			run2.setColor("000000");
			run2.setText( antecedente.getNombre());
			XWPFRun run3 = paragraph.createRun();
			run3.setText(" - " + messageSource.getMessage("reporte_cliente_final", null, locale) + " ");
			run3.setColor("0000ff");
			XWPFRun run4 = paragraph.createRun();
			run4.setColor("000000");
			run4.setText(antecedente.getClienteFinal().getNombre());
			
			if(campos.getDescFuncional()){
				createNewParagraphWithTitle(document, messageSource.getMessage("reporte_descripcion_funcional", null, locale), 
						antecedente.getDescFuncionalProyecto());
			}
			
			if(campos.getDescTecnica()){
				createNewParagraphWithTitle(document, messageSource.getMessage("reporte_descripcion_tecnica", null, locale),
						antecedente.getDescTecnicaProyecto());
			}
			
			if(campos.getDiagrama() && antecedente.getDiagrama() != null){
				createNewParagraphWithImage(messageSource.getMessage("reporte_diagrama", null, locale),
						document, antecedente.getDiagrama());
			}
			
			if(campos.getPerfilesRecursos()){
				createNewParagraphWithTitle(document, messageSource.getMessage("reporte_recursos_asignados", null, locale),
						antecedente.getRecursosPerfiles());
			}
			
			if(campos.getLogros()){
				createNewParagraphWithTitle(document, messageSource.getMessage("reporte_logros_obtenidos", null, locale),
						antecedente.getLogrosObtenidos());
			}
			
			if(campos.getCliente() && antecedente.getCliente() != null){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_cliente", null, locale) + " ",
						antecedente.getCliente().getNombre());
			}
			
			if(campos.getTipoSolucion()){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_solucion_negocio", null, locale) + " ", 
						antecedente.getTipoSolucion());
			}
			
			if(campos.getPais() && antecedente.getPais() != null){
				createNewParagraphWithSimpleLabel(document, 
						messageSource.getMessage("reporte_pais", null, locale) + " ", antecedente.getPais().getNombre());
			}
			
			if(campos.getServicio() && antecedente.getServicio() != null){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_servicio", null, locale) + " ",
						antecedente.getServicio().getNombre());
			}
			
			if(campos.getSbu() && antecedente.getSbu() != null){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_sbu", null, locale) + " ",
						antecedente.getSbu().getNombre());
			}
			
			if(campos.getDuracion()){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_duracion", null, locale) + " ",
						antecedente.getDuracion() + " meses");
			}
			
			if(campos.getHoras() && antecedente.getHoras() != null){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_horas", null, locale) + " ",
						antecedente.getHoras().toString() );
			}
			
			if(campos.getFechaInicioFin() && antecedente.getFechaInicio() != null && antecedente.getFechaFin() != null){
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_fechas", null, locale) + " ", 
						dateFormat.format(antecedente.getFechaInicio()) + " - " + dateFormat.format(antecedente.getFechaFin()));
			}
			
			if(campos.getMonto()){				
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_monto", null, locale) + " ", 
						antecedente.getMontoContrato() + " " + antecedente.getMonedaContrato().getNombre());				
			}
			
			if(campos.getLider()){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_lider", null, locale) + " ",
						antecedente.getLiderProyecto());			
			}
			
			if(campos.getContacto() && antecedente.getContacto() != null){
				paragraph = document.createParagraph();
				paragraph.setIndentationFirstLine(0);
				paragraph.setAlignment(ParagraphAlignment.LEFT);
				run = paragraph.createRun();
				run.setText(messageSource.getMessage("reporte_contacto", null, locale));
				run.addBreak();
				run.setBold(true);
				run = paragraph.createRun();			
				run.setText(antecedente.getContacto().getNombre() + "(" + antecedente.getContacto().getAreaPerteneciente() + ")");
				run.addBreak();
				run.setText(antecedente.getContacto().getEmail());
				run.addBreak();
				run.setText(antecedente.getContacto().getTelefono());
				run.setBold(false);
			}
			
			if(campos.getAreaUsuaria()){
				createNewParagraphWithSimpleLabel(document, messageSource.getMessage("reporte_area_usuaria", null, locale) + " ",
						antecedente.getAreaUsuaria());			
			}
			
			document.createParagraph();
		}
		
		return document;
	}
	
	private void createNewParagraphWithImage(String titulo, CustomXWPFDocument document, byte[] diagrama) throws 
			InvalidFormatException, IOException {		
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setIndentationFirstLine(0);
		XWPFRun run = paragraph.createRun();	 	
		run.setText(titulo);
		run.setBold(true);
		
		InputStream imageStream = new ByteArrayInputStream(diagrama);		
		String id = document.addPictureData(imageStream, Document.PICTURE_TYPE_JPEG);
		document.createPicture(id, document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 500, 400);
		
	}

	private void createNewParagraphWithSimpleLabel(CustomXWPFDocument document, String label, String value){
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setIndentationFirstLine(0);
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run = paragraph.createRun();
		run.setText(label);
		run.setBold(true);
		run = paragraph.createRun();
		run.setText(value);
		run.setBold(false);
	}
	
	private void createNewParagraphWithTitle(CustomXWPFDocument document, String titulo, String value){
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setIndentationFirstLine(0);
		XWPFRun run = paragraph.createRun();		
		run.setText(titulo);
		run.setBold(true);
		
		if(value != null){
			value = sacarHTMLInnecesario(value);
			org.jsoup.nodes.Document html = Jsoup.parse(value);
			Element element = Iterables.getOnlyElement(html.getElementsByTag("body"));
			for (Node node : element.childNodes()) {
				if(node.toString().startsWith("<ol>")){
					for (Node li : node.childNodes()) {
						createOrderedList(document,
								TextNode.createFromEncoded(li.childNode(0).toString(), "").text());
					}
				} else if(node.toString().startsWith("<ul>")){
					for (Node li : node.childNodes()) {						
						createUnorderedList(document,
								TextNode.createFromEncoded(li.childNode(0).toString(), "").text());
					}
				} else if(node.toString().startsWith("<br />")){
					
				} else if(node.toString().startsWith("<blockquote>")){
					String nodeString = node.toString();
					nodeString = nodeString.replace("<blockquote>", "\t");
					nodeString = nodeString.replace("</blockquote>", "");
					createSimpleParagraph(document, 
							TextNode.createFromEncoded(nodeString, "").text());
				} else{				
					createSimpleParagraph(document, 
							TextNode.createFromEncoded(node.toString(), "").text());
				}
			}
			
			document.createParagraph();
		}
		
	}
	
	private String sacarHTMLInnecesario(String value) {
		value = value.replace("<b>", "");
		value = value.replace("</b>", "");
		value = value.replace("<div>", "");
		value = value.replace("</div>", "");
		value = value.replace("<span>", "");
		value = value.replace("</span>", "");
		return value;
	}

	private void createUnorderedList(CustomXWPFDocument document, String value){
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setStyle("ul");
		XWPFRun run = paragraph.createRun();
		run.setText(value);
		run.setBold(false);
	}
	
	private void createOrderedList(CustomXWPFDocument document, String value){
		XWPFParagraph paragraph = document.createParagraph();
		paragraph.setStyle("ol");
		XWPFRun run = paragraph.createRun();
		run.setText(value);
		run.setBold(false);
	}
	
	private void createSimpleParagraph(CustomXWPFDocument document, String value){
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText(value);
		run.setBold(false);
	}


}
