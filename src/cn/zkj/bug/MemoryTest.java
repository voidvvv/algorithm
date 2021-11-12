//package cn.zkj.bug;
//
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MemoryTest {
//    public static void main(String[] args) {
//        MemoryTest memoryTest = new MemoryTest();
//
//        for (int x=0;x<500000;x++){
//            CustRespDto custRespDto = makeDto();
//            memoryTest.test(custRespDto);
//            System.out.println("第"+(x+1)+"次循环完成");
//        }
//        for (;;){}
//
//    }
//    public static CustRespDto makeDto(){
//        CustRespDto respDto = new CustRespDto();
////        BaseInfoDto baseInfoDto = new BaseInfoDto();
////        baseInfoDto.setName("张三");
////        baseInfoDto.setAge("20");
////        baseInfoDto.setUserId("1001");
////        respDto.setBaseInfoDto(baseInfoDto);
////
////        WokInfoDto wokInfoDto = new WokInfoDto();
////        wokInfoDto.setWorkAddress("aaabsssbddd");
////        wokInfoDto.setWorkInfo("workworkmoney");
////        respDto.setWokInfoDto(wokInfoDto);
////
////        List<RelInfoDto> relInfoDtos = new ArrayList<>();
////        RelInfoDto relInfoDto = new RelInfoDto();
////        relInfoDto.setName("mick");
////        relInfoDto.setTel("1001a");
////        relInfoDto.setUserId("1001");
////        relInfoDtos.add(relInfoDto);
////        respDto.setRelInfoDtos(relInfoDtos);
////
////        respDto.setCode("200");
////        respDto.setUserId("100000x");
//        return respDto;
//    }
//
//    public void test(CustRespDto respDto){
//        if (respDto==null){
//            throw new NullPointerException("a");
//        }
//        if (respDto.getCode().equals("200")){
//
//            List<RelInfoDto> relInfoDtos = respDto.getRelInfoDtos();
//            CustDto custDto = new CustDto();
//
//            composeWorkInfo(custDto,respDto);
//            composeBaseInfo(custDto,respDto);
//
//            if (relInfoDtos!=null){
//                composeRelInfo(custDto,respDto);
//            }
//            System.out.println(respDto.getUserId()+"==成功！！");
//        }else {
//            System.out.println(respDto.getUserId()+"==异常！！");
//        }
//
//    }
//
//
//    private void composeRelInfo(CustDto custDto, CustRespDto respDto) {
//        List<RelInfoDto> relInfoDtos = respDto.getRelInfoDtos();
//        List<RelInfoDto> tt=new ArrayList<>();
//        for (RelInfoDto relInfoDto:relInfoDtos){
//
//            tt.add(relInfoDto);
//        }
//        custDto.setRelInfoDtos(tt);
//    }
//
//    private void composeBaseInfo(CustDto custDto, CustRespDto respDto) {
//        BaseInfoDto baseInfoDto = respDto.getBaseInfoDto();
//        if (null!=baseInfoDto){
//            custDto.setName(baseInfoDto.getName());
//            custDto.setAge(baseInfoDto.getAge());
//            custDto.setUserId(baseInfoDto.getUserId());
//        }
//    }
//
//    private void composeWorkInfo(CustDto custDto, CustRespDto respDto) {
//        WokInfoDto wokInfoDto = respDto.getWokInfoDto();
//        if (null!=wokInfoDto){
//            custDto.setWorkAddress(wokInfoDto.getWorkAddress());
//            custDto.setWorkInfo(wokInfoDto.getWorkInfo());
//        }
//
//    }
//}
