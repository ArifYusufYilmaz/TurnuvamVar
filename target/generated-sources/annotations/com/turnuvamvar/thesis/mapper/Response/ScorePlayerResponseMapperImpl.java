package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
import com.turnuvamvar.thesis.entities.concretes.Player;
import com.turnuvamvar.thesis.entities.concretes.Score;
import com.turnuvamvar.thesis.entities.concretes.ScorePlayer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-05-29T12:02:55+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ScorePlayerResponseMapperImpl extends ScorePlayerResponseMapper {

    @Override
    public ScorePlayer mapScorePlayerResponseDtoToScorePlayer(ScorePlayerResponseDto scorePlayerResponseDto) {
        if ( scorePlayerResponseDto == null ) {
            return null;
        }

        ScorePlayer scorePlayer = new ScorePlayer();

        scorePlayer.setScore( scorePlayerResponseDtoToScore( scorePlayerResponseDto ) );
        scorePlayer.setPlayer( scorePlayerResponseDtoToPlayer( scorePlayerResponseDto ) );
        scorePlayer.setId( scorePlayerResponseDto.getId() );

        return scorePlayer;
    }

    @Override
    public ScorePlayerResponseDto mapScorePlayerToScorePlayerResponseDto(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }

        ScorePlayerResponseDto scorePlayerResponseDto = new ScorePlayerResponseDto();

        scorePlayerResponseDto.setScoreId( scorePlayerScoreId( scorePlayer ) );
        scorePlayerResponseDto.setPlayerId( scorePlayerPlayerId( scorePlayer ) );
        scorePlayerResponseDto.setId( scorePlayer.getId() );

        return scorePlayerResponseDto;
    }

    protected Score scorePlayerResponseDtoToScore(ScorePlayerResponseDto scorePlayerResponseDto) {
        if ( scorePlayerResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scorePlayerResponseDto.getScoreId() );

        return score;
    }

    protected Player scorePlayerResponseDtoToPlayer(ScorePlayerResponseDto scorePlayerResponseDto) {
        if ( scorePlayerResponseDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( scorePlayerResponseDto.getPlayerId() );

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
