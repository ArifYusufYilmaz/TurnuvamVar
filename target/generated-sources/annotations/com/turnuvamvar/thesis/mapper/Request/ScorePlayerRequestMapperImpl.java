package com.turnuvamvar.thesis.mapper.Request;

import com.turnuvamvar.thesis.dto.Request.ScorePlayerRequestDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T12:02:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ScorePlayerRequestMapperImpl extends ScorePlayerRequestMapper {

    @Override
    public ScorePlayer mapScorePlayerRequestDtoToScorePlayer(ScorePlayerRequestDto scorePlayerRequestDto) {
        if ( scorePlayerRequestDto == null ) {
            return null;
        }

        ScorePlayer scorePlayer = new ScorePlayer();

        scorePlayer.setScore( scorePlayerRequestDtoToScore( scorePlayerRequestDto ) );
        scorePlayer.setPlayer( scorePlayerRequestDtoToPlayer( scorePlayerRequestDto ) );

        return scorePlayer;
    }

    @Override
    public ScorePlayerRequestDto mapScorePlayerToScorePlayerRequestDto(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }

        ScorePlayerRequestDto scorePlayerRequestDto = new ScorePlayerRequestDto();

        scorePlayerRequestDto.setScoreId( scorePlayerScoreId( scorePlayer ) );
        scorePlayerRequestDto.setPlayerId( scorePlayerPlayerId( scorePlayer ) );

        return scorePlayerRequestDto;
    }

    @Override
    public List<ScorePlayer> mapScorePLayerRequestDtoListToScorePlayerList(Collection<ScorePlayerRequestDto> scorePlayerRequestDtoList) {
        if ( scorePlayerRequestDtoList == null ) {
            return null;
        }

        List<ScorePlayer> list = new ArrayList<ScorePlayer>( scorePlayerRequestDtoList.size() );
        for ( ScorePlayerRequestDto scorePlayerRequestDto : scorePlayerRequestDtoList ) {
            list.add( mapScorePlayerRequestDtoToScorePlayer( scorePlayerRequestDto ) );
        }

        return list;
    }

    @Override
    public List<ScorePlayerRequestDto> mapScorePlayerListToScorePlayerRequestDtoList(Collection<ScorePlayer> scorePLayer) {
        if ( scorePLayer == null ) {
            return null;
        }

        List<ScorePlayerRequestDto> list = new ArrayList<ScorePlayerRequestDto>( scorePLayer.size() );
        for ( ScorePlayer scorePlayer : scorePLayer ) {
            list.add( mapScorePlayerToScorePlayerRequestDto( scorePlayer ) );
        }

        return list;
    }

    protected Score scorePlayerRequestDtoToScore(ScorePlayerRequestDto scorePlayerRequestDto) {
        if ( scorePlayerRequestDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scorePlayerRequestDto.getScoreId() );

        return score;
    }

    protected Player scorePlayerRequestDtoToPlayer(ScorePlayerRequestDto scorePlayerRequestDto) {
        if ( scorePlayerRequestDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( scorePlayerRequestDto.getPlayerId() );

        return player;
    }

    private Long scorePlayerScoreId(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }
        Score score = scorePlayer.getScore();
        if ( score == null ) {
            return null;
        }
        Long id = score.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long scorePlayerPlayerId(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }
        Player player = scorePlayer.getPlayer();
        if ( player == null ) {
            return null;
        }
        Long id = player.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
