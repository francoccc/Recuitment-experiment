package com.demo.service;

import com.demo.entity.Enterprise;
import com.demo.entity.Position;
import com.demo.entity.Recuit;
import com.demo.repository.EnterpriseRepository;
import com.demo.repository.PositionRepository;
import com.demo.repository.RecuitRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EnterpriseService {
    @Autowired
    EnterpriseRepository enterpriseRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    RecuitRepository recuitRepository;

    public String register(String username,String password){
        if(enterpriseRepository.findByUsername(username)!=null){
            return "Be registered";
        }
        Enterprise enterprise=new Enterprise();
        enterprise.setUsername(username); enterprise.setPassword(password);
        enterpriseRepository.save(enterprise);
        return "Success";
    }

    public String login(String username,String password){
        if(enterpriseRepository.findByUsernameAndPassword(username,password)!=null){
            return "Success";
        }
        return "Fail";
    }

    public String changeinfo(String username,String name,String address,int scale,String info){
        Enterprise e = enterpriseRepository.findByUsername(username);
        e.setName(name);
        e.setAddress(address);
        e.setScale(scale);
        e.setInfo(info);
        enterpriseRepository.saveAndFlush(e);
        return "Success";
    }

    public String toRecuit(long eid,String name,int salary,int num,String demand){//发布岗位
        Position position=new Position();
        position.setDemand(demand); position.setSalary(salary); position.setName(name);
        position.setEid(eid);position.setNum(num);
        positionRepository.saveAndFlush(position);
        return "Success";
    }

    public String reRecuit(long id,char status){ //审核
        Recuit recuit=recuitRepository.findById(id);
        recuit.setStatus(status);
        if(status=='1'){
            long pid = recuit.getPid();
            Position p = positionRepository.findById(pid);
            if(p.getNum()>=1) p.setNum(p.getNum()-1);
            positionRepository.saveAndFlush(p);
        }
        recuitRepository.saveAndFlush(recuit);
        return "Success";
    }
}
