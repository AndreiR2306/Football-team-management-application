package com.example.appManagement.exporter;

import com.example.appManagement.entity.TeamMembers;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

public class PDFExporter {

    private static void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setColor(BaseColor.WHITE);

        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Surname", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Age", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Nationality", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Position", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Goals", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Assists", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Minutes Played", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Yellow Cards", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Red Cards", font));
        table.addCell(cell);
    }

    private static void writeTableData(PdfPTable table, List<TeamMembers> teamMembersList) {
        for (TeamMembers teamMember : teamMembersList) {
            table.addCell(String.valueOf(teamMember.getId()));
            table.addCell(teamMember.getName());
            table.addCell(teamMember.getSurname());
            table.addCell(String.valueOf(teamMember.getVarsta()));
            table.addCell(teamMember.getNationalitate());
            table.addCell(teamMember.getPozitie());
            table.addCell(String.valueOf(teamMember.getGoluri()));
            table.addCell(String.valueOf(teamMember.getPaseDecisive()));
            table.addCell(String.valueOf(teamMember.getMinuteJucate()));
            table.addCell(String.valueOf(teamMember.getCartonaseGalbene()));
            table.addCell(String.valueOf(teamMember.getCartonaseRosi()));
        }
    }

    public static ByteArrayInputStream teamMembersPDFExporter(List<TeamMembers> teamMembersList) {

        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfPTable table = new PdfPTable(11);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            writeTableHeader(table);
            writeTableData(table, teamMembersList);

            PdfWriter.getInstance(document, out);
            document.open();
            document.add(table);

            document.close();
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
