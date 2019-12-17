import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;




@SuppressWarnings("serial")
public class GraphicsDisplay extends JPanel {

    private ArrayList<Double[]> graphicsData;
    private ArrayList<Double[]> originalData;
    private int selectedMarker = -1;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double scaleX;
    private double scaleY;
    private double[][] viewport = new double[2][2];
    private ArrayList<double[][]> undoHistory = new ArrayList<>(5);
    private boolean showAxis = true;
    private boolean showMarkers = true;
    private Font axisFont;
    private Font labelsFont;
    private BasicStroke axisStroke;
    private BasicStroke markerStroke;
    private BasicStroke gridStroke;
    private static DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();
    private boolean scaleMode = false;
    private BasicStroke selectionStroke;
    private boolean changeMode = false;
    private double[] originalPoint = new double[2];
    private java.awt.geom.Rectangle2D.Double selectionRect = new java.awt.geom.Rectangle2D.Double();

    public GraphicsDisplay() {
        this.setBackground(Color.WHITE);
        this.axisStroke = new BasicStroke(2.0F, 0, 1, 10.0F, null, 0.0F);
        this.markerStroke = new BasicStroke(1.5F, 0, 1, 5.0F, null, 0.0F);
        this.selectionStroke = new BasicStroke(1.0F, 0, 0, 10.0F, new float[]{10.0F, 10.0F}, 0.0F);

        this.gridStroke = new BasicStroke(0.5F, 0, 1, 5.0F, new float[]{5.0F, 5.0F}, 2.0F);
        this.axisFont = new Font("Serif", 1, 36);
        this.labelsFont = new Font("Serif", 0, 10);
        this.addMouseMotionListener(new GraphicsDisplay.MouseMotionHandler());
        this.addMouseListener(new GraphicsDisplay.MouseHandler());
    }

    // Данный метод вызывается из обработчика элемента меню "Открыть файл с графиком"
    // главного окна приложения в случае успешной загрузки данных
    public void showGraphics(ArrayList<Double[]> graphicsData) {
        // Сохранить массив точек во внутреннем поле класса
       // this.graphicsData = graphicsData;
        // Запросить перерисовку компонента, т.е. неявно вызвать paintComponent()
        //repaint();
        this.graphicsData = graphicsData;
        this.originalData = new ArrayList<>(graphicsData.size());
        Iterator var3 = graphicsData.iterator();

        while(var3.hasNext()){
            Double[] point = (Double[])var3.next();
            Double[] newPoint = new Double[]{point[0], point[1]};
            this.originalData.add(newPoint);
        }

        this.minX = (graphicsData.get(0))[0];
        this.maxX = (graphicsData.get(graphicsData.size() - 1))[0];
        this.minY = (graphicsData.get(0))[1];
        this.maxY = this.minY;

        for(int i = 1; i < graphicsData.size(); ++i) {
            if ((graphicsData.get(i))[1] < this.minY) {
                this.minY = (graphicsData.get(i))[1];
            }

            if ((graphicsData.get(i))[1] > this.maxY) {
                this.maxY = (graphicsData.get(i))[1];
            }
        }
        this.zoomToRegion(this.minX, this.maxY, this.maxX, this.minY);
    }
    public void zoomToRegion(double x1, double y1, double x2, double y2) {
        this.viewport[0][0] = x1;
        this.viewport[0][1] = y1;
        this.viewport[1][0] = x2;
        this.viewport[1][1] = y2;
        this.repaint();
    }

    // Методы-модификаторы для изменения параметров отображения графика
    // Изменение любого параметра приводит к перерисовке области
    public void setShowAxis(boolean showAxis) {
        this.showAxis = showAxis;
        repaint();
    }

    public void setShowMarkers(boolean showMarkers) {
        this.showMarkers = showMarkers;
        repaint();
    }

    // Метод отображения всего компонента, содержащего график
    public void paintComponent(Graphics g) {
/*        *//* Шаг 1 - Вызвать метод предка для заливки области цветом заднего фона
         * Эта функциональность - единственное, что осталось в наследство от
         * paintComponent класса JPanel *//*
        super.paintComponent(g);

        // Шаг 2 - Если данные графика не загружены (при показе компонентапри запуске программы) - ничего не делать
        if (graphicsData == null || graphicsData.length == 0) return;

        // Шаг 3 - Определить минимальное и максимальное значения для координат X и Y
        minX = graphicsData[0][0];
        maxX = graphicsData[graphicsData.length - 1][0];
        minY = graphicsData[0][1];
        maxY = minY;
        // Найти минимальное и максимальное значение функции
        for (int i = 1; i < graphicsData.length; i++) {
            if (graphicsData[i][1] < minY) {
                minY = graphicsData[i][1];
            }
            if (graphicsData[i][1] > maxY) {
                maxY = graphicsData[i][1];
            }*/
        super.paintComponent(g);
        this.scaleX = this.getSize().getWidth() / (this.viewport[1][0] - this.viewport[0][0]);
        this.scaleY = this.getSize().getHeight() / (this.viewport[0][1] - this.viewport[1][1]);
        if (this.graphicsData != null && this.graphicsData.size() != 0) {
            Graphics2D canvas = (Graphics2D)g;
            Stroke oldStroke = canvas.getStroke();
            Color oldColor = canvas.getColor();
            Font oldFont = canvas.getFont();
            Paint oldPaint = canvas.getPaint();

            this.paintGrid(canvas);
            if (this.showAxis) {
                this.paintAxis(canvas);
                this.paintLabels(canvas);
            }

            this.paintGraphics(canvas);
            if (this.showMarkers) {
                this.paintMarkers(canvas);
            }

            this.paintSelection(canvas);
            canvas.setFont(oldFont);
            canvas.setPaint(oldPaint);
            canvas.setColor(oldColor);
            canvas.setStroke(oldStroke);
            }
    }
    private void paintSelection(Graphics2D canvas) {
        if (this.scaleMode) {
            canvas.setStroke(this.selectionStroke);
            canvas.setColor(Color.BLACK);
            canvas.draw(this.selectionRect);
        }
    }




   /*     *//* Шаг 4 - Определить (исходя из размеров окна) масштабы по осям X и Y - сколько пикселов
         * приходится на единицу длины по X и по Y *//*
        double scaleX = getSize().getWidth() / (maxX - minX);
        double scaleY = getSize().getHeight() / (maxY - minY);

        // Шаг 5 - Чтобы изображение было неискажѐнным - масштаб должен быть одинаков
        // Выбираем за основу минимальный
        scale = Math.min(scaleX, scaleY);

        // Шаг 6 - корректировка границ отображаемой области согласно выбранному масштабу
        if (scale == scaleX) {
            double yIncrement = (getSize().getHeight() / scale - (maxY - minY)) / 2;
            maxY += yIncrement;
            minY -= yIncrement;
        }
        if (scale == scaleY) {
            double xIncrement = (getSize().getWidth() / scale - (maxX - minX)) / 2;
            maxX += xIncrement;
            minX -= xIncrement;
        }

        // Шаг 7 - Сохранить текущие настройки холста
        Graphics2D canvas = (Graphics2D) g;
        Stroke oldStroke = canvas.getStroke();
        Color oldColor = canvas.getColor();
        Paint oldPaint = canvas.getPaint();
        Font oldFont = canvas.getFont();

        // Шаг 8 - В нужном порядке вызвать методы отображения элементов графика
        if (showAxis) paintAxis(canvas);
        // Затем отображается сам график
        paintGraphics(canvas);
        // Затем (если нужно) отображаются маркеры точек, по которым строился график.
        if (showMarkers) paintMarkers(canvas);

        // Шаг 9 - Восстановить старые настройки холста
        canvas.setFont(oldFont);
        canvas.setPaint(oldPaint);
        canvas.setColor(oldColor);
        canvas.setStroke(oldStroke);*/


    // Отрисовка графика по прочитанным координатам
    protected void paintGraphics(Graphics2D canvas) {
        // Выбрать линию для рисования графика
        canvas.setStroke(graphicsStroke);
        // Выбрать цвет линии
        canvas.setColor(Color.RED);

        GeneralPath graphics = new GeneralPath();
        for (int i = 0; i < graphicsData.length; i++) {
            // Преобразовать значения (x,y) в точку на экране point
            Point2D.Double point = xyToPoint(graphicsData[i][0], graphicsData[i][1]);
            if (i > 0) {
                // Не первая итерация цикла - вести линию в точку point
                graphics.lineTo(point.getX(), point.getY());
            } else {
                // Первая итерация цикла - установить начало пути в точку point
                graphics.moveTo(point.getX(), point.getY());
            }
        }
        // Отобразить график
        canvas.draw(graphics);
    }

    // Отображение маркеров точек, по которым рисовался график
    protected void paintMarkers(Graphics2D canvas) {

        // Шаг 1 - Установить специальное перо для черчения контуров маркеров
        canvas.setStroke(markerStroke);
        // Выбрать красный цвета для контуров маркеров
        canvas.setColor(Color.RED);
        // Выбрать красный цвет для закрашивания маркеров внутри
        canvas.setPaint(Color.RED);

        // Шаг 2 - Организовать цикл по всем точкам графика
        for (Double[] point : graphicsData) {
            // Инициализировать эллипс как объект для представления маркера
            Ellipse2D.Double marker = new Ellipse2D.Double();
            Point2D.Double center = xyToPoint(point[0], point[1]);
            // Угол прямоугольника - отстоит на расстоянии (3,3)
            Point2D.Double corner = shiftPoint(center, 3, 3);
            // Задать эллипс по центру и диагонали
            marker.setFrameFromCenter(center, corner);
            canvas.draw(marker); // Начертить контур маркера
            canvas.fill(marker); // Залить внутреннюю область маркера
        }
    }

    // Метод, обеспечивающий отображение осей координат
    protected void paintAxis(Graphics2D canvas) {

        // Установить особое начертание для осей
        canvas.setStroke(axisStroke);
        // Оси рисуются чѐрным цветом
        canvas.setColor(Color.BLACK);
        // Стрелки заливаются чѐрным цветом
        canvas.setPaint(Color.BLACK);
        // Подписи к координатным осям делаются специальным шрифтом
        canvas.setFont(axisFont);
        // Создать объект контекста отображения текста - для получения характеристик устройства (экрана)
        FontRenderContext context = canvas.getFontRenderContext();

        // Определить, должна ли быть видна ось Y на графике
        if (minX <= 0.0 && maxX >= 0.0) {
            canvas.draw(new Line2D.Double(xyToPoint(0, maxY), xyToPoint(0, minY)));
            // Стрелка оси Y
            GeneralPath arrow = new GeneralPath();
            // Установить начальную точку ломаной точно на верхний конец оси Y
            Point2D.Double lineEnd = xyToPoint(0, maxY);
            arrow.moveTo(lineEnd.getX(), lineEnd.getY());
            // Вести левый "скат" стрелки в точку с относительными координатами (5,20)
            arrow.lineTo(arrow.getCurrentPoint().getX() + 5, arrow.getCurrentPoint().getY() + 20);
            // Вести нижнюю часть стрелки в точку с относительными координатами (-10, 0)
            arrow.lineTo(arrow.getCurrentPoint().getX() - 10, arrow.getCurrentPoint().getY());
            // Замкнуть треугольник стрелки
            arrow.closePath();
            canvas.draw(arrow); // Нарисовать стрелку
            canvas.fill(arrow); // Закрасить стрелку
            // Нарисовать подпись к оси Y
            // Определить, сколько места понадобится для надписи "y"
            Rectangle2D bounds = axisFont.getStringBounds("y", context);
            Point2D.Double labelPos = xyToPoint(0, maxY);
            // Вывести надпись в точке с вычисленными координатами
            canvas.drawString("y", (float) labelPos.getX() + 10, (float) (labelPos.getY() - bounds.getY()));
        }

        // Определить, должна ли быть видна ось X на графике
        if (minY <= 0.0 && maxY >= 0.0) {
            canvas.draw(new Line2D.Double(xyToPoint(minX, 0), xyToPoint(maxX, 0)));
            GeneralPath arrow = new GeneralPath();
            Point2D.Double lineEnd = xyToPoint(maxX, 0);
            arrow.moveTo(lineEnd.getX(), lineEnd.getY());
            arrow.lineTo(arrow.getCurrentPoint().getX() - 20, arrow.getCurrentPoint().getY() - 5);
            arrow.lineTo(arrow.getCurrentPoint().getX(), arrow.getCurrentPoint().getY() + 10);
            arrow.closePath();
            canvas.draw(arrow);
            canvas.fill(arrow);
            Rectangle2D bounds = axisFont.getStringBounds("x", context);
            Point2D.Double labelPos = xyToPoint(maxX, 0);
            canvas.drawString("x", (float) (labelPos.getX() -
                    bounds.getWidth() - 10), (float) (labelPos.getY() + bounds.getY()));
        }
    }

    // Метод-помощник, осуществляющий преобразование координат.
    protected Point2D.Double xyToPoint(double x, double y) {
        // Вычисляем смещение X от самой левой точки (minX)
        double deltaX = x - minX;
        // Вычисляем смещение Y от точки верхней точки (maxY)
        double deltaY = maxY - y;
        return new Point2D.Double(deltaX * scale, deltaY * scale);
    }

    /* Метод-помощник, возвращающий экземпляр класса Point2D.Double
     * смещѐнный по отношению к исходному на deltaX, deltaY */
    protected Point2D.Double shiftPoint(Point2D.Double src, double deltaX, double deltaY) {

        // Инициализировать новый экземпляр точки
        Point2D.Double dest = new Point2D.Double();
        // Задать еѐ координаты как координаты существующей точки + заданные смещения
        dest.setLocation(src.getX() + deltaX, src.getY() + deltaY);
        return dest;
    }

    public class MouseHandler extends MouseAdapter {
        public MouseHandler() {
        }

        public void mouseClicked(MouseEvent ev) {
            if (ev.getButton() == 3) {
                if (GraphicsDisplay.this.undoHistory.size() > 0) {
                    GraphicsDisplay.this.viewport = GraphicsDisplay.this.undoHistory.get(GraphicsDisplay.this.undoHistory.size() - 1);
                    GraphicsDisplay.this.undoHistory.remove(GraphicsDisplay.this.undoHistory.size() - 1);
                } else {
                    GraphicsDisplay.this.zoomToRegion(GraphicsDisplay.this.minX, GraphicsDisplay.this.maxY, GraphicsDisplay.this.maxX, GraphicsDisplay.this.minY);
                }

                GraphicsDisplay.this.repaint();
            }

        }

        public void mousePressed(MouseEvent ev) {
            if (ev.getButton() == 1) {
                GraphicsDisplay.this.selectedMarker = GraphicsDisplay.this.findSelectedPoint(ev.getX(), ev.getY());
                GraphicsDisplay.this.originalPoint = GraphicsDisplay.this.translatePointToXY(ev.getX(), ev.getY());
                if (GraphicsDisplay.this.selectedMarker >= 0) {
                    GraphicsDisplay.this.changeMode = true;
                    GraphicsDisplay.this.setCursor(Cursor.getPredefinedCursor(8));
                } else {
                    GraphicsDisplay.this.scaleMode = true;
                    GraphicsDisplay.this.setCursor(Cursor.getPredefinedCursor(5));
                    GraphicsDisplay.this.selectionRect.setFrame(ev.getX(), ev.getY(), 1.0D, 1.0D);
                }

            }
        }

        public void mouseReleased(MouseEvent ev) {
            if (ev.getButton() == 1) {
                GraphicsDisplay.this.setCursor(Cursor.getPredefinedCursor(0));
                if (GraphicsDisplay.this.changeMode) {
                    GraphicsDisplay.this.changeMode = false;
                } else {
                    GraphicsDisplay.this.scaleMode = false;
                    double[] finalPoint = GraphicsDisplay.this.translatePointToXY(ev.getX(), ev.getY());
                    GraphicsDisplay.this.undoHistory.add(GraphicsDisplay.this.viewport);
                    GraphicsDisplay.this.viewport = new double[2][2];
                    GraphicsDisplay.this.zoomToRegion(GraphicsDisplay.this.originalPoint[0], GraphicsDisplay.this.originalPoint[1], finalPoint[0], finalPoint[1]);
                    GraphicsDisplay.this.repaint();
                }
            }
        }
    }

    public class MouseMotionHandler implements MouseMotionListener {
        public MouseMotionHandler() {
        }

        public void mouseDragged(MouseEvent ev) {
            if (GraphicsDisplay.this.changeMode) {
                double[] currentPoint = GraphicsDisplay.this.translatePointToXY(ev.getX(), ev.getY());
                double newY = (GraphicsDisplay.this.graphicsData.get(GraphicsDisplay.this.selectedMarker))[1] + (currentPoint[1] - (GraphicsDisplay.this.graphicsData.get(GraphicsDisplay.this.selectedMarker))[1]);
                if (newY > GraphicsDisplay.this.viewport[0][1]) {
                    newY = GraphicsDisplay.this.viewport[0][1];
                }

                if (newY < GraphicsDisplay.this.viewport[1][1]) {
                    newY = GraphicsDisplay.this.viewport[1][1];
                }

                (GraphicsDisplay.this.graphicsData.get(GraphicsDisplay.this.selectedMarker))[1] = newY;
                GraphicsDisplay.this.repaint();
            } else {
                double width = (double)ev.getX() - GraphicsDisplay.this.selectionRect.getX();
                if (width < 5.0D) {
                    width = 5.0D;
                }

                double height = (double)ev.getY() - GraphicsDisplay.this.selectionRect.getY();
                if (height < 5.0D) {
                    height = 5.0D;
                }

                GraphicsDisplay.this.selectionRect.setFrame(GraphicsDisplay.this.selectionRect.getX(), GraphicsDisplay.this.selectionRect.getY(), width, height);
                GraphicsDisplay.this.repaint();
            }

        }

        public void mouseMoved(MouseEvent ev) {
            GraphicsDisplay.this.selectedMarker = GraphicsDisplay.this.findSelectedPoint(ev.getX(), ev.getY());
            if (GraphicsDisplay.this.selectedMarker >= 0) {
                GraphicsDisplay.this.setCursor(Cursor.getPredefinedCursor(8));
            } else {
                GraphicsDisplay.this.setCursor(Cursor.getPredefinedCursor(0));
            }

            GraphicsDisplay.this.repaint();
        }
    }
}
