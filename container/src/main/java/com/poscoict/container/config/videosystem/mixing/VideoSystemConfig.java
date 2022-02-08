package com.poscoict.container.config.videosystem.mixing;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
 * <------ JavaConfig2(DVDPlayerConfig) + JavaConfig1(DVDConfig)
 *  import
 *  
 *  JavaConfig1 + JavaConfig2
 */


@Configuration
@Import({DVDConfig.class, DVDPlayerConfig.class})
public class VideoSystemConfig {

}
