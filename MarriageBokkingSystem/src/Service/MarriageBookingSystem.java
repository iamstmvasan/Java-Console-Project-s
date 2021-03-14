package Service;

import Entity.Applicant;
import Exceptional.ApplicantNotFound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MarriageBookingSystem {
    List<Applicant> applicantList = new ArrayList<>();

    public boolean addApplicant(Applicant applicant){
        List<Applicant> list = applicantList.stream().filter(i -> i.getApplicantId() == applicant.getApplicantId()).
                                collect(Collectors.toList());
        if(!list.isEmpty())
            return false;
        applicantList.add(applicant);
        return true;
    }

    public List<Applicant> findMatch(Applicant applicant) throws ApplicantNotFound {
        List<Applicant> list = applicantList.stream().
                filter(i -> !( i.getSex().equalsIgnoreCase(applicant.getSex() ) ) && i.getAge() >= applicant.getAge()).
                collect(Collectors.toList());
        if (list.isEmpty())
            throw new ApplicantNotFound("No Matching Applicant !");
        return list;
    }

    public boolean assignApplicant(int applicantId, Applicant applicant){
        List<Applicant> list = applicantList.stream().filter(i -> i.getApplicantId() == applicantId).
                                collect(Collectors.toList());
        List<Applicant> list1 = applicantList.stream().filter(i -> i.getApplicantId() == applicant.getApplicantId()).
                collect(Collectors.toList());

        if(list.isEmpty())
            return false;
        list.get(0).setPerson(applicant);
        list1.get(0).setPerson(list.get(0));
        return true;
    }

    public boolean dropProposal(int applicantId){
        List<Applicant> list = applicantList.stream().filter(i -> i.getApplicantId() == applicantId).collect(Collectors.toList());
        if(list.isEmpty())
            return false;
        list.get(0).setPerson(null);
        return true;
    }

    public Map<String, Integer> findApplicantSummary(){
        Map <String, Integer> map = new HashMap<>();

        int maleCount = 0, femaleCount = 0;
        maleCount = (int)applicantList.stream().
                filter(i -> i.getSex().equalsIgnoreCase("Male") && i.getPerson() == null).
                count();
        femaleCount = (int)applicantList.stream().
                filter(i -> i.getSex().equalsIgnoreCase("female") && i.getPerson() == null).
                count();

        map.put("Male", maleCount);
        map.put("Female", femaleCount);

        return map;
    }

}
