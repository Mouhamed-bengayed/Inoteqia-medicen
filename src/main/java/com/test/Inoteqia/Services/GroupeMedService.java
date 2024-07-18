package com.test.Inoteqia.Services;

import com.test.Inoteqia.DTO.GrpMedDTO;
import com.test.Inoteqia.Entity.GroupeMed;
import com.test.Inoteqia.Entity.Medecin;
import com.test.Inoteqia.Entity.Utilisateur;
import com.test.Inoteqia.Reposotories.GroupeMedReposotory;
import com.test.Inoteqia.Reposotories.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GroupeMedService {
    @Autowired
    private GroupeMedReposotory groupeMedReposotory;
    @Autowired
    private MedecinRepository medecinRepository;


    public void deleteGroupeMed(Long id){
        groupeMedReposotory.deleteById(id);
    }
    public void addGroupeMed(GrpMedDTO groupeMed){
        GroupeMed groupeMed1 = new GroupeMed();
        groupeMed1.setTitre(groupeMed.getTitre());
        groupeMed1.setDescription(groupeMed.getDescription());
        groupeMed1.setDate(groupeMed.getDate() != null ? groupeMed.getDate() : new Date());
        List<Long> medecinsIds = groupeMed.getMedecins();

            for (Long id : medecinsIds){
               Medecin medecin1 = medecinRepository.findById(id).get();

                groupeMed1.getMedecins().add(medecin1);
            }

        groupeMedReposotory.save(groupeMed1);
    }


    public GroupeMed getGroupeMedById(Long id){
        return groupeMedReposotory.findById(id).get();
    }
    public List<GroupeMed> getAllGroupeMed(){

        return groupeMedReposotory.findAll();
    }
    public List<Medecin>showlistmeds(Long id){

        return groupeMedReposotory.findById(id).get().getMedecins();
    }
    public GroupeMed updateGroupeMed (GrpMedDTO grp ,Long id)
    {
        GroupeMed groupeMed = groupeMedReposotory.findById(id).get();
        if(grp.getTitre()!=null){
            groupeMed.setTitre(grp.getTitre());
        }
        if(grp.getDescription()!=null){
            groupeMed.setDescription(grp.getDescription());
        }
        List<Long> medecinsIds = grp.getMedecins();
        for(Long medId:medecinsIds)
        {
            Medecin medecin=medecinRepository.findById(medId).get();
            if(!groupeMed.getMedecins().contains(medecin))
            {
                groupeMed.getMedecins().add(medecin);

            }
        }
        return groupeMedReposotory.save(groupeMed);

    }
}
