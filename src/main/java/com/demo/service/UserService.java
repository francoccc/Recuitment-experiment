package com.demo.service;

import com.demo.entity.Position;
import com.demo.entity.Recuit;
import com.demo.entity.User;
import com.demo.repository.PositionRepository;
import com.demo.repository.RecuitRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    RecuitRepository recuitRepository;

    public String register(String username,String password){
        if(userRepository.findByUsername(username)!=null){
            return "Be registered";
        }
        User user=new User();
        user.setUsername(username); user.setPassword(password);
        userRepository.save(user);
        return "Success";
    }

    public String login(String username,String password){
        if(userRepository.findByUsernameAndPassword(username,password)!=null){
            return "Success";
        }
        return "Fail";
    }

    public String changeinfo(String username,String name,int age,String sex,String school,
                             String education,String major,String info){//添加与修改信息
        User user=userRepository.findByUsername(username);
        user.setName(name);
        user.setAge(age);
        user.setSex(sex);
        user.setSchool(school);
        user.setEducation(education);
        user.setMajor(major);
        user.setInfo(info);
        userRepository.saveAndFlush(user);
        return "Success";
    }

    public List<Position> getPositions(String...args){ //条件搜索岗位
        List<Position> list=null;
        if(args[0].equals("namelike")){
            list=positionRepository.findByNameLike(args[1]);
        }
        else if(args[0].equals("salary")){
            int s_min=Integer.parseInt(args[1]);
            int s_max=Integer.parseInt(args[2]);
            list=positionRepository.findBySalary(s_min,s_max);
        }
        else{
            list=positionRepository.findAll();
        }
        return list;
    }

    public String recuit(long uid,long pid){ //招聘
        Recuit recuit=new Recuit();
        recuit.setUid(uid); recuit.setPid(pid);
        recuit.setStatus('0');
        recuitRepository.save(recuit);
        return "Success";
    }

    public List<Position> getRecuit(String...args){ //查看已经投递和投递成功
        List<Recuit> list=recuitRepository.findByUid(Long.parseLong(args[0]));
        List<Position> plist=new ArrayList<Position>();
        for(Recuit recuit:list){
            if(args[1].equals("1") && recuit.getStatus()!='1') continue;
            long id = recuit.getPid();
            Position p =positionRepository.findById(id);
            plist.add(p);
        }
        return plist;
    }
}
