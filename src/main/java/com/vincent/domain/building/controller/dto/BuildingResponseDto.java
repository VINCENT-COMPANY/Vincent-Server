package com.vincent.domain.building.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class BuildingResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BuildingInfo {

        Long buildingId;
        String buildingName;
        String buildingImage;
        String buildingAddress;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BuildingAndFloorInfo {

        Long buildingId;
        String buildingName;
        String buildingImage;
        String buildingAddress;
        List<FloorWithSocket> floorWithSocketList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BuildingList {

        List<BuildingInfo> buildingInfos;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BuildingLocation {

        Long buildingId;
        Double latitude;
        Double longitude;

    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BuildingLocationList {

        List<BuildingLocation> buildingLocations;

    }

    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FloorInfo {

        String buildingName;
        Long floors;
        Integer currentFloor;
        String floorImage;
        List<SpaceInfoProjection> spaceInfoList;



    }



    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FloorInfoProjection {


        private String buildingName;
        private Long floors;
        private Integer currentFloor;
        private String floorImage;

    }




    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonPropertyOrder({"spaceName", "socketExistence", "xCoordinate", "yCoordinate"})
    public static class SpaceInfoProjection {


        @JsonProperty("spaceName")
        private String spaceName;

        @JsonProperty("xcoordinate")
        private Double xCoordinate;

        @JsonProperty("ycoordinate")
        private Double yCoordinate;

        @JsonProperty("socketExistence")
        private Boolean socketExistence;

    }


    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FloorWithSocket {

        Long floorId;
        Integer floorLevel;


    }



    /*
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FloorInfoProjection2 {


        private String buildingName;
        private Long floors;
        private Integer currentFloor;
        private String floorImage;
        List<A> aa;

    }

     */


}
