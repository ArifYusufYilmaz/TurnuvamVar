package com.turnuvamvar.thesis.business.concretes;

import com.turnuvamvar.thesis.business.abstracts.StageTeamService;
import com.turnuvamvar.thesis.core.utilities.results.DataResult;
import com.turnuvamvar.thesis.core.utilities.results.SuccessDataResult;
import com.turnuvamvar.thesis.dataAccess.abstracts.StageTeamDao;
import com.turnuvamvar.thesis.dto.StageTeamDto;
import com.turnuvamvar.thesis.entities.concretes.StageTeam;
import com.turnuvamvar.thesis.mapper.StageTeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StageTeamManager implements StageTeamService {
    @Autowired
    private StageTeamDao stageTeamDao;
    private StageTeamMapper stageTeamMapper;
    @Autowired
    public StageTeamManager(StageTeamDao stageTeamDao) {
        this.stageTeamDao = stageTeamDao;
    }
    @Autowired
    public void setStageTeamMapper(StageTeamMapper stageTeamMapper) {
        this.stageTeamMapper = stageTeamMapper;
    }

    @Override
    public DataResult<StageTeamDto> createOneStageTeam(StageTeamDto newStageTeamDto) {
        // aynısından kaydettirme! kontrol et.
        StageTeam stageTeam = this.stageTeamMapper.mapStageTeamDtoToStage(newStageTeamDto);
        StageTeamDto stageTeamDto = this.stageTeamMapper.mapStageTeamToStageTeamDto(this.stageTeamDao.save(stageTeam));
        return new SuccessDataResult<StageTeamDto>(stageTeamDto);
    }
}
