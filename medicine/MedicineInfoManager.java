package com.nader.aria.assistant_blue.entities.medicine;

import com.nader.aria.assistant_blue.entities.abstracts.BaseEntity;
import com.nader.aria.assistant_blue.entities.account.Login;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="MEDICINE_INFO_MANAGERS")
public class MedicineInfoManager extends BaseEntity {

    @OneToOne( cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} ,fetch = FetchType.EAGER )
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany( cascade = {CascadeType.ALL},fetch = FetchType.LAZY , mappedBy ="medicineInfoManager")
    private List<MedicineInfo> medicineInfos;

    public Login getLogin(){ return login; }
    public void setLogin(Login login){ this.login = login; }

    public List<MedicineInfo> getMedicineInfos(){ return medicineInfos; }
    public void setMedicineInfos(List<MedicineInfo> medicineInfos ){ this.medicineInfos = medicineInfos; }

}
