package com.tesda.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.springframework.web.servlet.view.AbstractView;
import org.apache.commons.lang.StringUtils;

import com.tesda.model.DTO.TDMNonStandardSearchDTO;

public class TDMGenerateX12FormatView  extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                "X12Format.txt");
        response.setContentType("text/plain");
        response.setHeader(headerKey, headerValue);
		
		/*ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);*/
		
		TDMNonStandardSearchDTO nonStandDTO =(TDMNonStandardSearchDTO)	model.get("tdmNonStandSearchDTO");
		/*String outText ="ISA*00*          *00*          *ZZ*TXEBS          *ZZ*94             *100310*1430*U*00401*111967293*0*T*>~\n"
				  + "GS*BE*TXEBS*94*20100310*1430*1*X*004010X095A1~\n"
				  + "ST*834*945549460~\n"
				  + "BGN*00*1465465 1454*20100310*1430****2~\n"
				  + "REF*38*94~\n"
				  + "DTP*007*D8*20100101~\n"
				  + "N1*P5*HHSC*ZZ*223567890~\n" //3-sponsor name, 5-Tin Number/Sponser Identifier
				  + "N1*IN*HCSC*FI*123456789~\n" //3-Insurer Name, 5-Payer/Insurer Identification Code
				  + "INS*Y*18*021*20*A*E**FT~\n"
				  + "REF*0F*654654565~\n" //3-Member Reference Number
				  + "DTP*394*D8*20100101~\n"
				  + "DTP*474*D8*20101212~\n"
				  + "NM1*IL*1*"+nonStandDTO.getFirstName()+"*"+nonStandDTO.getMiddleName()+"*"+nonStandDTO.getLastName()+"~\n" //4-First Name, 5-Middle Name, 6-Last Name
				  + "PER*IP**TE*1234567890~\n"
				  + "N3*17203 E Lookout Drive*APT 2~\n" //1-Address 1, 2-Address2 
				  + "N4*Richardson*TX*785920000~\n" //2-city, 3-State,4-zipcode
				  + "DMG*D8*19780302*M~\n" //3-DOB, 4-Gender
				  + "HD*021**HMO*13/04/R/N////*IND\n"
				  + "DTP*348*D8*20100101~\n"//4-coverage begin date
				  + "DTP*349*D8*20101212~\n"//4-Coverage end date
				  + "LX*1~\n"
				  + "NM1*P3*2*E Lookout Dr*****34*789004049*72~\n"
				  + "N4*Richardson*TX*785920000~\n"
				  + "PER*IC**TE*9996652452~\n"
				  + "SE*23*945549460~\n"
				  + "GE*1*1~\n"
				  + "IEA*1*111967293~";*/
		
		checkForEmptyValues(nonStandDTO);
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date = new Date();
		String[] dates=	dateFormat.format(date).split(" ");
		String[] time= dates[1].split(":");
		 
		ServletOutputStream out = response.getOutputStream();
		
		out.println("ISA*00*          *00*          *ZZ*TXEBS          *ZZ*94             *100310*1430*U*00401*111967293*0*T*>~");
		out.println("GS*BE*TXEBS*94*20100310*1430*1*X*004010X095A1~");
		out.println("ST*834*945549460~");
		out.println("BGN*00*1465465 1454*"+convertDate(dates[0])+"*"+time[0]+time[1]+"****2~");
		out.println("REF*38*94~");
		out.println("DTP*007*D8*20100101~");
		out.println("N1*P5*"+nonStandDTO.getSponsorName()+"*ZZ*"+nonStandDTO.getSponsorTIN()+"~"); // 3-sponsor name, 5-Tin Number/Sponser Identifier
		out.println("N1*IN*"+nonStandDTO.getProviderName()+"*FI*"+nonStandDTO.getProviderNum()+"~"); // 3-Insurer Name, 5-Payer/Insurer Identification Code
		out.println("INS*Y*18*021*20*A*E**FT~");
		out.println("REF*0F*"+nonStandDTO.getMemRefId()+"~"); // 3-Member Reference Number
		out.println("DTP*394*D8*"+nonStandDTO.getMemEffStartDt()+"~");
		out.println("DTP*474*D8*"+nonStandDTO.getMemEndDate()+"~");
		out.println("NM1*IL*1*" + nonStandDTO.getFirstName() + "*"
				+ nonStandDTO.getMiddleName() + "*" + nonStandDTO.getLastName()
				+ "~"); // 4-First Name, 5-Middle Name, 6-Last Name
		out.println("PER*IP**TE*1234567890~");
		out.println("N3*"+nonStandDTO.getAddrLine1()+"*"+nonStandDTO.getAddrLine2()+"~");// 1-Address 1,
														// 2-Address2
		out.println("N4*"+nonStandDTO.getCity()+"*"+nonStandDTO.getCorpId()+"*"+nonStandDTO.getHomeZipCode()+"~"); // 2-city, 3-State,4-zipcode
		out.println("DMG*D8*"+nonStandDTO.getDob()+"*"+nonStandDTO.getGender()+"~"); // 3-DOB, 4-Gender
		out.println("HD*021**"+nonStandDTO.getPlanType()+"*13/04/R/N////*IND");
		out.println("DTP*348*D8*"+nonStandDTO.getMcgsEffDate()+"~");// 4-coverage begin date
		out.println("DTP*349*D8*"+nonStandDTO.getMcgsEndDate()+"~");// 4-Coverage end date
		out.println("LX*1~");
		out.println("NM1*P3*2*E Lookout Dr*****34*789004049*72~");
		out.println("N4*Richardson*TX*785920000~");
		out.println("PER*IC**TE*9996652452~");
		out.println("SE*23*945549460~");
		out.println("GE*1*1~");
		out.println("IEA*1*111967293~");

		out.flush();
		out.close();
		/*csvWriter.writeHeader(outText);
		csvWriter.close();*/
	}
	
	public void checkForEmptyValues(TDMNonStandardSearchDTO nonStandDTO)
	{
		if(StringUtils.isEmpty(nonStandDTO.getFirstName()))
		{
			nonStandDTO.setFirstName("HCSC");
		}
		if(StringUtils.isEmpty(nonStandDTO.getLastName()))
		{
			nonStandDTO.setLastName("HCSC");
		}
		if(StringUtils.isEmpty(nonStandDTO.getMiddleName()))
		{
			nonStandDTO.setMiddleName("HCSC");
		}
		if(StringUtils.isEmpty(nonStandDTO.getDob()))
		{
			nonStandDTO.setDob("HCSC");
		}
		else
		{
			nonStandDTO.setDob(convertDate(nonStandDTO.getDob()));
		}
		if(StringUtils.isEmpty(nonStandDTO.getCity()))
		{
			nonStandDTO.setCity("CITY");
		}
		if(StringUtils.isEmpty(nonStandDTO.getHomeZipCode()))
		{
			nonStandDTO.setHomeZipCode("12345");
		}
		if(StringUtils.isEmpty(nonStandDTO.getAddrLine1()))
		{
			nonStandDTO.setAddrLine1("Address 1");
		}
		if(StringUtils.isEmpty(nonStandDTO.getAddrLine2()))
		{
			nonStandDTO.setAddrLine2("Address 2");
		}
		if(StringUtils.isEmpty(nonStandDTO.getGender()))
		{
			nonStandDTO.setGender("M");
		}
		if(StringUtils.isEmpty(nonStandDTO.getCorpId()))
		{
			nonStandDTO.setCorpId("STATE");
		}
		if(StringUtils.isEmpty(nonStandDTO.getCoverage()))
		{
			nonStandDTO.setCoverage("COVER");
		}
		if(StringUtils.isEmpty(nonStandDTO.getGroupNum()))
		{
			nonStandDTO.setGroupNum("GROUPNUM");
		}
		if(StringUtils.isEmpty(nonStandDTO.getSponsorName()))
		{
			nonStandDTO.setSponsorName("NAME"); ;
		}		
		
		if(StringUtils.isEmpty(nonStandDTO.getSponsorTIN()))
		{
			nonStandDTO.setSponsorTIN("12345");
		}
		if(StringUtils.isEmpty(nonStandDTO.getProviderName()))
		{
			nonStandDTO.setProviderName("NAME");
		}
		if(StringUtils.isEmpty(nonStandDTO.getProviderNum()))
		{
			nonStandDTO.setProviderNum("12345");
		}
		if(StringUtils.isEmpty(nonStandDTO.getMemRefId()))
		{
			nonStandDTO.setMemRefId("12345");
		}
		if(StringUtils.isEmpty(nonStandDTO.getMemEffStartDt()))
		{
			nonStandDTO.setMemEffStartDt("99991231");
		}
		else
		{
			nonStandDTO.setMemEffStartDt(convertDate(nonStandDTO.getMemEffStartDt()));
		}
		
		if(StringUtils.isEmpty(nonStandDTO.getMemEndDate()))
		{
			nonStandDTO.setMemEndDate("99991231");
		}
		else
		{
			nonStandDTO.setMemEndDate(convertDate(nonStandDTO.getMemEndDate()));
		}
		
		if(StringUtils.isEmpty(nonStandDTO.getMcgsEffDate()))
		{
			nonStandDTO.setMcgsEffDate("99991231");
		}
		else
		{
			nonStandDTO.setMcgsEffDate(convertDate(nonStandDTO.getMcgsEffDate()));
		}
		
		if(StringUtils.isEmpty(nonStandDTO.getMcgsEndDate()))
		{
			nonStandDTO.setMcgsEndDate("99991231");
		}
		else
		{
			nonStandDTO.setMcgsEndDate(convertDate(nonStandDTO.getMcgsEndDate()));
		}
	}
	
	public String convertDate(String date)
	{
		String convertedDate ="";
		
		String[] dates= date.split("/");
		
		convertedDate = dates[2]+dates[0]+dates[1];
		return  convertedDate;
	}

}
