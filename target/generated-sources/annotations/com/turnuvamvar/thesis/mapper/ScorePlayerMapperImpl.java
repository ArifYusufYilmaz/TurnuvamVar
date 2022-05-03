package com.turnuvamvar.thesis.mapper;

import com.turnuvamvar.thesis.dto.ScorePlayerDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-04T01:13:21+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ScorePlayerMapperImpl extends ScorePlayerMapper {

    @Override
    public ScorePlayer mapScorePlayerDtoToScorePlayer(ScorePlayerDto scorePlayerDto) {
        if ( scorePlayerDto == null ) {
            return null;
        }

        ScorePlayer scorePlayer = new ScorePlayer();

        scorePlayer.setScore( scorePlayerDtoToScore( scorePlayerDto ) );
        scorePlayer.setPlayer( scorePlayerDtoToPlayer( scorePlayerDto ) );

        return scorePlayer;
    }

    @Override
    public ScorePlayerDto mapScorePlayerToScorePlayerDto(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }

        ScorePlayerDto scorePlayerDto = new ScorePlayerDto();

        scorePlayerDto.setScoreId( scorePlayerScoreId( scorePlayer ) );
        scorePlayerDto.setPlayerId( scorePlayerPlayerId( scorePlayer ) );

        return scorePlayerDto;
    }

    protected Score scorePlayerDtoToScore(ScorePlayerDto scorePlayerDto) {
        if ( scorePlayerDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scorePlayerDto.getScoreId() );

        return score;
    }

    protected Player scorePlayerDtoToPlayer(ScorePlayerDto scorePlayerDto) {
        if ( scorePlayerDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( scorePlayerDto.getPlayerId() );

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
