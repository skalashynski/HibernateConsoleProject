package epam.booking_apartment.controller.command.impl;

import epam.booking_apartment.controller.command.ICommand;
import epam.booking_apartment.model.Apartment;
import epam.booking_apartment.service.ApartmentService;
import epam.booking_apartment.service.exception.ServiceException;
import epam.booking_apartment.service.impl.ApartmentServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetAllApartment implements ICommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        ApartmentService service = new ApartmentServiceImpl();
        try {
            List<Apartment> apartmentList= service.getAllApartments();
            request.setAttribute("apartmentList",apartmentList);
        } catch (ServiceException e) {
            System.err.println("ошибка");
        }
        return "/WEB-INF/view/apartments.jsp";
    }
}
