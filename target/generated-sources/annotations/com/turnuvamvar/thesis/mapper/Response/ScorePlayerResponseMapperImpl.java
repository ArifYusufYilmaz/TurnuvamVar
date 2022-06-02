package com.turnuvamvar.thesis.mapper.Response;

import com.turnuvamvar.thesis.dto.Response.ScorePlayerResponseDto;
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
    date = "2022-06-02T21:42:07+0300",
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
        scorePlayerResponseDto.setScore( scorePlayerScoreScore( scorePlayer ) );
        scorePlayerResponseDto.setPlayerId( scorePlayerPlayerId( scorePlayer ) );
        scorePlayerResponseDto.setPlayerFirstName( scorePlayerPlayerPlayerFirstName( scorePlayer ) );
        scorePlayerResponseDto.setPlayerLastName( scorePlayerPlayerPlayerLastName( scorePlayer ) );
        scorePlayerResponseDto.setId( scorePlayer.getId() );

        return scorePlayerResponseDto;
    }

    @Override
    public List<ScorePlayerResponseDto> mapScorePlayerListToScorePlayerResponseDtoList(Collection<ScorePlayer> scorePlayerList) {
        if ( scorePlayerList == null ) {
            return null;
        }

        List<ScorePlayerResponseDto> list = new ArrayList<ScorePlayerResponseDto>( scorePlayerList.size() );
        for ( ScorePlayer scorePlayer : scorePlayerList ) {
            list.add( mapScorePlayerToScorePlayerResponseDto( scorePlayer ) );
        }

        return list;
    }

    @Override
    public List<ScorePlayer> mapScorePlayerResponseDtoListToScorePlayerList(Collection<ScorePlayerResponseDto> scorePlayerResponseDtoList) {
        if ( scorePlayerResponseDtoList == null ) {
            return null;
        }

        List<ScorePlayer> list = new ArrayList<ScorePlayer>( scorePlayerResponseDtoList.size() );
        for ( ScorePlayerResponseDto scorePlayerResponseDto : scorePlayerResponseDtoList ) {
            list.add( mapScorePlayerResponseDtoToScorePlayer( scorePlayerResponseDto ) );
        }

        return list;
    }

    protected Score scorePlayerResponseDtoToScore(ScorePlayerResponseDto scorePlayerResponseDto) {
        if ( scorePlayerResponseDto == null ) {
            return null;
        }

        Score score = new Score();

        score.setId( scorePlayerResponseDto.getScoreId() );
        score.setScore( scorePlayerResponseDto.getScore() );

        return score;
    }

    protected Player scorePlayerResponseDtoToPlayer(ScorePlayerResponseDto scorePlayerResponseDto) {
        if ( scorePlayerResponseDto == null ) {
            return null;
        }

        Player player = new Player();

        player.setId( scorePlayerResponseDto.getPlayerId() );
        player.setPlayerFirstName( scorePlayerResponseDto.getPlayerFirstName() );
        player.setPlayerLastName( scorePlayerResponseDto.getPlayerLastName() );

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

    private int scorePlayerScoreScore(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return 0;
        }
        Score score = scorePlayer.getScore();
        if ( score == null ) {
            return 0;
        }
        int score1 = score.getScore();
        return score1;
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

    private String scorePlayerPlayerPlayerFirstName(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }
        Player player = scorePlayer.getPlayer();
        if ( player == null ) {
            return null;
        }
        String playerFirstName = player.getPlayerFirstName();
        if ( playerFirstName == null ) {
            return null;
        }
        return playerFirstName;
    }

    private String scorePlayerPlayerPlayerLastName(ScorePlayer scorePlayer) {
        if ( scorePlayer == null ) {
            return null;
        }
        Player player = scorePlayer.getPlayer();
        if ( player == null ) {
            return null;
        }
        String playerLastName = player.getPlayerLastName();
        if ( playerLastName == null ) {
            return null;
        }
        return playerLastName;
    }
}
