package com.poscoict.container.config.videosystem.mixing;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poscoict.container.videosystem.DVDPlayer;
import com.poscoict.container.videosystem.DigitalVideoDisc;

/*
 * JavaConfig2(DVDPlayerConfig) <--------- JavaConfig1(DVDConfig)
 * 								  import
 * 
 * JavaConfig2 + JavaConfig1
 */

@Configuration
@Import({DVDConfig.class})
public class DVDPlayerConfig {
	
	// bean 생성 메소드 
	@Bean
	public DVDPlayer dvdPlayer(@Qualifier("avengersInfinityWar") DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
}
