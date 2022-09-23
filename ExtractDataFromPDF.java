package alabama;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import arkansas.RunnerClass;



public class ExtractDataFromPDF
{
	public static boolean petFlag;
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		
				//File file = RunnerClass.getLastModified();
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_01.22_12.22_448_Camden_Cove_Cir_AL_Thor.pdf");//Space issue
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_9.21_9.22_4609_Bonnett_Cir_AL_Montgomery.pdf");//Space issue
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_10.21_10.22_240_Addison_Dr_AL_Mitchell_-_Hawkins.pdf");
				
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_11.21_10.22_1034_Washington_Ct_AL_Rosenberg.pdf");
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_0722_0623_202_Annetta_Cir_AL_Shoemake.pdf"); //space for prorated
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_12.21_12.22_155_Americana_Dr_Odenville_AL_Woods_Woods.pdf");
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_12.21_12.22_106_Stone_Rd_AL_Pete.pdf");
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_11.21_11.22_16386_Creek_Dr_AL_Hoskins.pdf");
				//File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_11.21_11.22_248_Stonebriar_Dr_AL_Grayson_-_Cobb.pdf");
				File file = new File("C:\\Users\\user\\Downloads\\Alabama\\Lease_11.21_10.22_4970_Deer_Foot_Cv_AL_Osborn.pdf");

				
				FileInputStream fis = new FileInputStream(file);
				PDDocument document = PDDocument.load(fis);
			    String text = new PDFTextStripper().getText(document);
			    System.out.println(text);
			    System.out.println("------------------------------------------------------------------");
			    try
			    {
			    	AB_PropertyWare.commensementDate = text.substring(text.indexOf(PDFAppConfig.AB_commencementDate_Prior)+PDFAppConfig.AB_commencementDate_Prior.length(),text.indexOf(PDFAppConfig.AB_expirationDate_Prior));
			    	System.out.println("Commensement Date = "+AB_PropertyWare.commensementDate.substring(AB_PropertyWare.commensementDate.lastIndexOf(":")+1));
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.commensementDate = "Error";
			    	e.printStackTrace();
			    }
			   try
			    {
				   AB_PropertyWare.expirationDate = text.substring(text.indexOf(PDFAppConfig.AB_expirationDate_Prior));
				   System.out.println("Expiration Date = "+AB_PropertyWare.expirationDate.substring(AB_PropertyWare.expirationDate.indexOf(":")+1,AB_PropertyWare.expirationDate.indexOf(":")+17));
			    }
			    catch(Exception e)
			    {
			    	 AB_PropertyWare.expirationDate = "Error";
			    	 e.printStackTrace();
			    }
			   try
			    {
				    AB_PropertyWare.proratedRent = text.substring(text.indexOf(PDFAppConfig.AB_proratedRent_Prior)+PDFAppConfig.AB_proratedRent_Prior.length(),text.indexOf(PDFAppConfig.AB_proratedRent_After));
				    System.out.println("Prorated Rent = "+AB_PropertyWare.proratedRent);
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.proratedRent = "Error";
			    	e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.proratedRentDate = text.substring(text.indexOf(PDFAppConfig.AB_proratedRentDate_Prior)+PDFAppConfig.AB_proratedRentDate_Prior.length(),text.indexOf(PDFAppConfig.AB_proratedRentDate_After));
				    System.out.println("Prorated Rent Date= "+AB_PropertyWare.proratedRentDate.trim());
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.proratedRentDate = "Error";
			    	e.printStackTrace();
			    }
			    
			    try
			    {
				    AB_PropertyWare.monthlyRentDate = text.substring(text.indexOf(PDFAppConfig.AB_fullRentDate_Prior)+PDFAppConfig.AB_fullRentDate_Prior.length(),text.indexOf(PDFAppConfig.AB_fullRentDate_After));
				    System.out.println("Monthly Rent Date= "+AB_PropertyWare.monthlyRentDate.trim());
			    }
			    catch(Exception e)
			    {
			    	try
			    	{
			    		AB_PropertyWare.monthlyRentDate = text.substring(text.indexOf(PDFAppConfig.AB_fullRentDate_Prior)+PDFAppConfig.AB_fullRentDate_Prior.length(),text.indexOf(PDFAppConfig.AB_fullRentDate1_After));
					   	System.out.println("Monthly Rent Date= "+AB_PropertyWare.monthlyRentDate.trim());
			    	}
			    	catch(Exception e1)
				    {
				    	AB_PropertyWare.petRent = "Error";  
				    	e1.printStackTrace();
				    }
			    }
			    try
			    {
				    AB_PropertyWare.monthlyRent = text.substring(text.indexOf(PDFAppConfig.AB_fullRent_Prior)+PDFAppConfig.AB_fullRent_Prior.length(),text.indexOf(PDFAppConfig.AB_fullRent_After));
				    System.out.println("Monthly Rent "+AB_PropertyWare.monthlyRent.trim());
			    }
			    catch(Exception e)
			    {
			    	 AB_PropertyWare.monthlyRent = "Error";
			    	 e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.adminFee = text.substring(text.indexOf(PDFAppConfig.AB_adminFee_Prior)+PDFAppConfig.AB_adminFee_Prior.length()).split(" ")[0];
				    System.out.println("Admin Fee = "+AB_PropertyWare.adminFee.trim());
			    }
			    catch(Exception e)
			    {
				    AB_PropertyWare.adminFee = "Error";
				    e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.airFilterFee = text.substring(text.indexOf(PDFAppConfig.AB_airFilterFee_Prior)+PDFAppConfig.AB_airFilterFee_Prior.length(),text.indexOf(PDFAppConfig.AB_airFilterFee_After));
				    System.out.println("Air Filter Fee = "+AB_PropertyWare.airFilterFee.trim());
			    }
			    catch(Exception e)
			    {
			    AB_PropertyWare.airFilterFee = "Error";
			    e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.earlyTermination = text.substring(text.indexOf(PDFAppConfig.AB_earlyTerminationFee_Prior)+PDFAppConfig.AB_earlyTerminationFee_Prior.length(),text.indexOf(PDFAppConfig.AB_earlyTerminationFee_After));
				    System.out.println("Early Termination  = "+AB_PropertyWare.earlyTermination.trim());
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.earlyTermination = "Error";	
			    	e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.occupants = text.substring(text.indexOf(PDFAppConfig.AB_occupants_Prior)+PDFAppConfig.AB_occupants_Prior.length(),text.indexOf(PDFAppConfig.AB_occupants_After));
				    System.out.println("Occupants = "+AB_PropertyWare.occupants.trim());
			    }
			    catch(Exception e)
			    {
				    AB_PropertyWare.occupants ="Error";	
				    e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.lateChargeDay = text.substring(text.indexOf(PDFAppConfig.AB_lateChargeDay_Prior)+PDFAppConfig.AB_lateChargeDay_Prior.length(),text.indexOf(PDFAppConfig.AB_lateChargeDay_After));
				    System.out.println("Late Charge Day = "+AB_PropertyWare.lateChargeDay.trim());
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.lateChargeDay = "Error";	
			    	e.printStackTrace();
			    }
			    try
			    {
				    AB_PropertyWare.lateChargeFee = text.substring(text.indexOf(PDFAppConfig.AB_lateFee_Prior)+PDFAppConfig.AB_lateFee_Prior.length(),text.indexOf(PDFAppConfig.AB_lateFee_After));
				    System.out.println("Late Charge Fee = "+AB_PropertyWare.lateChargeFee.trim());
			    }
			    catch(Exception e)
			    {
				    AB_PropertyWare.lateChargeFee ="Error";	
				    e.printStackTrace();
			    }
			    
			    petFlag = text.contains(PDFAppConfig.AB_petAgreementAvailabilityCheck);
			    System.out.println("Pet Addendum Available = "+petFlag);
			    if(petFlag ==true)
			    {
			    	try
			    	{
			    	AB_PropertyWare.petSecurityDeposit = text.substring(text.indexOf(PDFAppConfig.AB_securityDeposity_Prior)+PDFAppConfig.AB_securityDeposity_Prior.length(),text.indexOf(PDFAppConfig.AB_securityDeposity_After));
				    System.out.println("Security Deposit = "+AB_PropertyWare.petSecurityDeposit.trim());
			    	}
			    	catch(Exception e)
			    	{
			    	AB_PropertyWare.petSecurityDeposit = "Error";	
			    	e.printStackTrace();
			    	}
			    	if(RunnerClass.onlyDigits(AB_PropertyWare.petSecurityDeposit)==true)
				    {
				    	System.out.println("Security Deposit is checked");
				    }
			    	//TODO Check
			    	/*   try
					    {
			    		AR_PropertyWare.proratedPetRent = text.substring(text.indexOf(PDFAppConfig.AR_proratedPetRent_Prior)+PDFAppConfig.AR_proratedPetRent_Prior.length());
					    //AR_PropertyWare.proratedPetRent = proratedPetRentRaw.substring(proratedPetRentRaw.indexOf("Tenant will pay Landlord $")+"Tenant will pay Landlord $".length());//,proratedPetRentRaw.indexOf(AppConfig.AR_proratedPetRent_After));
					    System.out.println("Prorated Pet Rent = "+AR_PropertyWare.proratedPetRent.trim());
					    }
					    catch(Exception e)
					    {
					    AR_PropertyWare.proratedPetRent = "Error";	
					    }*/
			    	
			    	try
				    {
			    		 AB_PropertyWare.petRent = text.substring(text.indexOf(PDFAppConfig.AB_petRent_Prior)+PDFAppConfig.AB_petRent_Prior.length(),text.indexOf(PDFAppConfig.AB_petRent_After));
						 System.out.println("Pet rent = "+AB_PropertyWare.petRent.trim());
				    }
			    	catch(Exception e)
				    {
			    		try
			    		{
			    			AB_PropertyWare.petRent = text.substring(text.indexOf(PDFAppConfig.AB_petRent1_Prior)+PDFAppConfig.AB_petRent1_Prior.length(),text.indexOf(PDFAppConfig.AB_petRent1_After));
							 System.out.println("Pet rent = "+AB_PropertyWare.petRent.trim());
			    		}
			    		
			    		catch(Exception e1)
					    {
					    	AB_PropertyWare.petRent = "Error";  
					    	e1.printStackTrace();
					    }
				    }
				    	//AB_PropertyWare.petRent = "Error";  
				    	//e.printStackTrace();
				    
			    	
			    	String newText = text.replace("Type:","");
				    AB_PropertyWare.countOfTypeWordInText = ((text.length() - newText.length())/"Type:".length());
				    System.out.println("Type: occurences = "+AB_PropertyWare.countOfTypeWordInText);
				    
				    try
				    {
				    AB_PropertyWare.pet1Type = text.substring(text.indexOf(PDFAppConfig.AB_pet1Type_Prior)+PDFAppConfig.AB_pet1Type_Prior.length(),text.indexOf(PDFAppConfig.AB_pet1Type_After));
				    System.out.println("Pet 1 Type = "+AB_PropertyWare.pet1Type.trim());
				    }
				    catch(Exception e)
				    {
				    	AB_PropertyWare.pet1Type = "Error";
				    	e.printStackTrace();
				    }
				    //Check if service animal is there
				    //PropertyWare.pet2Type = text.substring(text.indexOf("Type:", text.indexOf("Type:")+1)+AppConfig.AB_pet1Type_Prior.length(),text.indexOf("Breed:", text.indexOf("Breed:")+1));
				    try
				    {
				    AB_PropertyWare.pet2Type = text.substring(RunnerClass.nthOccurrence(text, "Type:", 2)+PDFAppConfig.AB_pet1Type_Prior.length(),RunnerClass.nthOccurrence(text, "Breed:", 2));
				    System.out.println("Pet 2 Type = "+AB_PropertyWare.pet2Type);
				    }
				    catch(Exception e) 
				    {
				    	AB_PropertyWare.pet2Type =	 "Error";
				    	e.printStackTrace();
				    }
				    try
				    {
					    int pet1Breedindex1 = RunnerClass.nthOccurrence(text, "Breed:", 1)+PDFAppConfig.AB_pet1Type_Prior.length()+1;
					    String subString = text.substring(pet1Breedindex1);
					    int pet1Breedindex2 = RunnerClass.nthOccurrence(subString,"Name:",1);
					   // System.out.println("Index 2 = "+(index2+index1));
					    AB_PropertyWare.pet1Breed = text.substring(pet1Breedindex1,(pet1Breedindex2+pet1Breedindex1));
					    System.out.println("Pet 1 Breed = "+text.substring(pet1Breedindex1,(pet1Breedindex2+pet1Breedindex1)));
				    }
				    catch(Exception e)
				    {
				    	 AB_PropertyWare.pet1Breed = "Error";
				    	 e.printStackTrace();
				    }
				    try
				    {
					    int pet2Breedindex1 = RunnerClass.nthOccurrence(text, "Breed:", 2)+"Breed:".length()+1;
					    String subString2 = text.substring(pet2Breedindex1);
					    int pet2Breedindex2 = RunnerClass.nthOccurrence(subString2,"Name:",1);
					   // System.out.println("Index 2 = "+(index2+index1));
					    AB_PropertyWare.pet2Breed = text.substring(pet2Breedindex1,(pet2Breedindex2+pet2Breedindex1));
					    System.out.println("Pet 2 Breed = "+text.substring(pet2Breedindex1,(pet2Breedindex2+pet2Breedindex1)));
				    }
				    catch(Exception e)
				    {
				    	AB_PropertyWare.pet2Breed = "Error";
				    	e.printStackTrace();
				    }
				    try
				    {
					    int pet1Weightindex1 = RunnerClass.nthOccurrence(text, "Weight:", 1)+"Weight:".length()+1;
					    String pet1WeightSubstring = text.substring(pet1Weightindex1);
					    int pet1WeightIndex2 = RunnerClass.nthOccurrence(pet1WeightSubstring,"Age:",1);
					   // System.out.println("Index 2 = "+(index2+index1));
					    AB_PropertyWare.pet1Weight = text.substring(pet1Weightindex1,(pet1WeightIndex2+pet1Weightindex1));
					    System.out.println("Pet 1 Weight = "+text.substring(pet1Weightindex1,(pet1WeightIndex2+pet1Weightindex1)));
				    }
				    catch(Exception e)
				    {
				    	AB_PropertyWare.pet1Weight = "Error";
				    	e.printStackTrace();
				    }
				    try
				    {
					    int pet2Weightindex1 = RunnerClass.nthOccurrence(text, "Weight:", 2)+"Weight:".length()+1;
					    String pet2WeightSubstring = text.substring(pet2Weightindex1);
					    int pet2WeightIndex2 = RunnerClass.nthOccurrence(pet2WeightSubstring,"Age:",1);
					   // System.out.println("Index 2 = "+(index2+index1));
					    AB_PropertyWare.pet2Weight = text.substring(pet2Weightindex1,(pet2WeightIndex2+pet2Weightindex1));
					    System.out.println("Pet 2 Weight = "+text.substring(pet2Weightindex1,(pet2WeightIndex2+pet2Weightindex1)));
				    }
				    catch(Exception e)
				    {
				    	AB_PropertyWare.pet2Weight = "Error";
				    	e.printStackTrace();
				    }
				    if(AB_PropertyWare.countOfTypeWordInText>2)
			        {
					    try
					    {
					    AB_PropertyWare.serviceAnimalType = text.substring(RunnerClass.nthOccurrence(text, "Type:", 3)+PDFAppConfig.AB_pet1Type_Prior.length(),RunnerClass.nthOccurrence(text, "Breed:", 3));
					    System.out.println("Service Animal Type = "+AB_PropertyWare.serviceAnimalType);
					    }
					    catch(Exception e)
					    {
					    	 AB_PropertyWare.serviceAnimalType = "Error";
					    	 e.printStackTrace();
					    }
					    try
					    {
						    int serviceAnimalBreedindex1 = RunnerClass.nthOccurrence(text, "Breed:", 3)+"Breed:".length()+1;
						    String serviceAnimalsubString = text.substring(serviceAnimalBreedindex1);
						    int serviceAnimalBreedindex2 = RunnerClass.nthOccurrence(serviceAnimalsubString,"Name:",1);
						   // System.out.println("Index 2 = "+(index2+index1));
						    AB_PropertyWare.serviceAnimalBreed = text.substring(serviceAnimalBreedindex1,(serviceAnimalBreedindex2+serviceAnimalBreedindex1));
						    System.out.println("Service Animal Breed = "+text.substring(serviceAnimalBreedindex1,(serviceAnimalBreedindex2+serviceAnimalBreedindex1)));
					    }
					    catch(Exception e)
					    {
					    	AB_PropertyWare.serviceAnimalBreed = "Error";
					    	e.printStackTrace();
					    }
				  
					    try
					    {
					    int serviceAnimalWeightindex1 = RunnerClass.nthOccurrence(text, "Weight:", 3)+"Weight:".length()+1;
					    String serviceAnimalWeightSubstring = text.substring(serviceAnimalWeightindex1);
					    int serviceAnimalWeightIndex2 = RunnerClass.nthOccurrence(serviceAnimalWeightSubstring,"Age:",1);
					   // System.out.println("Index 2 = "+(index2+index1));
					    AB_PropertyWare.serviceAnimalWeight = text.substring(serviceAnimalWeightindex1,(serviceAnimalWeightIndex2+serviceAnimalWeightindex1));
					    System.out.println("Service Animal Weight = "+text.substring(serviceAnimalWeightindex1,(serviceAnimalWeightIndex2+serviceAnimalWeightindex1)));
					    }
					    catch(Exception e)
					    {
					    	AB_PropertyWare.serviceAnimalWeight = "Error";
					    	e.printStackTrace();
					    }  
			        }
				    try
				    {
				    	AB_PropertyWare.petOneTimeNonRefundableFee = text.substring(text.indexOf(PDFAppConfig.AB_petFeeOneTime_Prior)+PDFAppConfig.AB_petFeeOneTime_Prior.length(),text.indexOf(PDFAppConfig.AB_petFeeOneTime_After));
					    System.out.println("pet one time non refundable = "+AB_PropertyWare.petOneTimeNonRefundableFee.trim());
				    }
				    catch(Exception e)
				    {
				    	AB_PropertyWare.petOneTimeNonRefundableFee =  "Error";
				    	e.printStackTrace();
				    }  
				   
			    }
			    try
			    {
			    	AB_PropertyWare.additionalLateCharges = text.substring(text.indexOf(PDFAppConfig.AB_additionalLateChargesPerDay_Prior)+PDFAppConfig.AB_additionalLateChargesPerDay_Prior.length(),text.indexOf(PDFAppConfig.AB_additionalLateChargesPerDay_After));
				    System.out.println("Additional late charges = "+AB_PropertyWare.additionalLateCharges.trim());
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.additionalLateCharges =  "Error";	
			    	e.printStackTrace();
			    }
			    try
			    {
			    	AB_PropertyWare.additionalLateChargesLimit = text.substring(text.indexOf(PDFAppConfig.AB_additionalLateChargesLimit_Prior)+PDFAppConfig.AB_additionalLateChargesLimit_Prior.length(),text.indexOf(PDFAppConfig.AB_additionalLateChargesLimit_After));
				    System.out.println("additional Late Charges Limit = "+AB_PropertyWare.additionalLateChargesLimit.trim());
			    }
			    catch(Exception e)
			    {
			    	AB_PropertyWare.additionalLateChargesLimit =  "Error";	
			    	e.printStackTrace();
			    }
		    }

   

}
