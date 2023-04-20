package com.stgk.gather.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author mashir0zhao
 * @since 2023-03-27
 */
@TableName("stgk_transformer")
@ApiModel(value = "Transformer对象", description = "")
public class Transformer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("变压器名称")
    private String transformerName;

    @ApiModelProperty("变压器状态")
    private Integer transformerStatus;

    @ApiModelProperty("变压器状态")
    private BigDecimal ratedCurrent;

    @ApiModelProperty("带载运行时间")
    private Integer onloadRuntime;

    @ApiModelProperty("空载运行时间")
    private Integer offloadRuntime;

    @ApiModelProperty("退出运行时间")
    private Integer exitRuntime;

    @ApiModelProperty("过负载次数")
    private Integer overloadNum;

    @ApiModelProperty("过负载时间(分)")
    private Integer overloadTime;

    @ApiModelProperty("过负载寿命折损(分)")
    private Integer overloadDamage;

    @ApiModelProperty("变压器容量")
    private Integer transformerVolume;

    @ApiModelProperty("从机id")
    private Integer slaveId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建者")
    private String createBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新者")
    private String updateBy;

    public BigDecimal getRatedCurrent() {
        return ratedCurrent;
    }

    public void setRatedCurrent(BigDecimal ratedCurrent) {
        this.ratedCurrent = ratedCurrent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTransformerName() {
        return transformerName;
    }

    public void setTransformerName(String transformerName) {
        this.transformerName = transformerName;
    }
    public Integer getTransformerStatus() {
        return transformerStatus;
    }

    public void setTransformerStatus(Integer transformerStatus) {
        this.transformerStatus = transformerStatus;
    }
    public Integer getOnloadRuntime() {
        return onloadRuntime;
    }

    public void setOnloadRuntime(Integer onloadRuntime) {
        this.onloadRuntime = onloadRuntime;
    }
    public Integer getOffloadRuntime() {
        return offloadRuntime;
    }

    public void setOffloadRuntime(Integer offloadRuntime) {
        this.offloadRuntime = offloadRuntime;
    }
    public Integer getExitRuntime() {
        return exitRuntime;
    }

    public void setExitRuntime(Integer exitRuntime) {
        this.exitRuntime = exitRuntime;
    }
    public Integer getOverloadNum() {
        return overloadNum;
    }

    public void setOverloadNum(Integer overloadNum) {
        this.overloadNum = overloadNum;
    }
    public Integer getOverloadTime() {
        return overloadTime;
    }

    public void setOverloadTime(Integer overloadTime) {
        this.overloadTime = overloadTime;
    }
    public Integer getOverloadDamage() {
        return overloadDamage;
    }

    public void setOverloadDamage(Integer overloadDamage) {
        this.overloadDamage = overloadDamage;
    }
    public Integer getTransformerVolume() {
        return transformerVolume;
    }

    public void setTransformerVolume(Integer transformerVolume) {
        this.transformerVolume = transformerVolume;
    }
    public Integer getSlaveId() {
        return slaveId;
    }

    public void setSlaveId(Integer slaveId) {
        this.slaveId = slaveId;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "Transformer{" +
            "id=" + id +
            ", transformerName=" + transformerName +
            ", transformerStatus=" + transformerStatus +
            ", onloadRuntime=" + onloadRuntime +
            ", offloadRuntime=" + offloadRuntime +
            ", exitRuntime=" + exitRuntime +
            ", overloadNum=" + overloadNum +
            ", overloadTime=" + overloadTime +
            ", overloadDamage=" + overloadDamage +
            ", transformerVolume=" + transformerVolume +
            ", slaveId=" + slaveId +
            ", createTime=" + createTime +
            ", createBy=" + createBy +
            ", updateTime=" + updateTime +
            ", updateBy=" + updateBy +
        "}";
    }
}
