package com.germaine.lumbarRobot.service;

import com.germaine.lumbarRobot.entity.RobotGaitEntity;

public interface RobotGaitService {
    RobotGaitEntity getRobotGaitEntityByMobile(String mobile);

    public int add(RobotGaitEntity entity);

    public int update(RobotGaitEntity entity);

    public int saveBak(RobotGaitEntity entity);
}
