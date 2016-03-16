package edu.istic.mmm.mmmtp3.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by maxime on 16/03/2016.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Region {

    @Getter @Setter
    public String name;

    public String getUrl() {
        return "http://technoresto.org/vdf/"+ getName().toLowerCase() +"/index.html";
    }
}
