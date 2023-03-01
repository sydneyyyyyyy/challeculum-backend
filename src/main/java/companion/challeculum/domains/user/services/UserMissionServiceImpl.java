package companion.challeculum.domains.user.services;

import companion.challeculum.common.exceptions.intented.NoSubmittedMissionExistException;
import companion.challeculum.domains.user.dto.UserMission;
import companion.challeculum.domains.user.repositories.UserMissionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("usermissionService")
public class UserMissionServiceImpl implements UserMissionService {
    @Autowired
    UserMissionDao userMissionDao;

    public void createUserMission(long userId, int missionId, String imageUrl) {
        userMissionDao.createUserMission(userId, missionId, imageUrl);
    }

    public void updateUserMission(UserMission userMission, long userId, long missionId) {
        UserMission selectUserMission = userMissionDao.getUserMissionByUserId(userId, missionId);
        if (selectUserMission != null) {
            selectUserMission.setSubmitAt(userMission.getSubmitAt());
            selectUserMission.setIsAccepted(userMission.getIsAccepted());
            selectUserMission.setImageUrl(userMission.getImageUrl());
            userMissionDao.updateUserMission(selectUserMission);
        } else {
            throw new NoSubmittedMissionExistException("유저는 미션을 시작하지 않았습니다.");
        }
    }

    @Override
    public UserMission getUserMissionByUserId(long userId, long missionId) {
        return userMissionDao.getUserMissionByUserId(userId, missionId);
    }
}
