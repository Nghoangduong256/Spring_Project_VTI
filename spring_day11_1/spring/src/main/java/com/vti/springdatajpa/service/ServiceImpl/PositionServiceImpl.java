//package com.vti.springdatajpa.service.IService;
//
////import com.vti.springdatajpa.entity.PositionEntity;
//import com.vti.springdatajpa.entity.PositionName;
//import com.vti.springdatajpa.repository.PositionRepository;
//import com.vti.springdatajpa.service.PositionService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class PositionServiceImpl implements PositionService {
//
////    @Autowired
////    private PositionRepository positionRepository;
////
////    @Override
////    public PositionEntity getPositionById(int id) {
////        return  positionRepository.findById(id).get();
////    }
////
////    @Override
////    public List<PositionEntity> getAllPosition() {
////        return positionRepository.findAll();
////    }
////
////    @Override
////    public PositionEntity getPositionByName(PositionName positionName) {
////        return positionRepository.findByName(positionName);
////    }
////
////    @Override
////    public void createPosition(PositionEntity positionEntity) {
////        positionRepository.save(positionEntity);
////    }
//}
